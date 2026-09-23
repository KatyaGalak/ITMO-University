#include "main.h"
#include "tm1637.h"

volatile uint32_t tickCount;
uint32_t lastScanTime;
uint32_t last_display_update;
uint16_t counter;
char lastKey;
static char previousKey;

static const char MATH_OPS[4] = {'+', '-', '*', '/'};

static const uint8_t DIGIT_MAP[] = {0x3F, 0x06, 0x5B, 0x4F, 0x66, 0x6D, 0x7D, 0x07, 0x7F, 0x6F};

typedef enum {
  STATE_WAIT_A = 0,
  STATE_SELECT_OP,
  STATE_WAIT_B,
  STATE_SHOW_RESULT
} CalcState;

#define MASK_BLANK 0x00
#define MASK_MINUS 0x40
#define MASK_DOT   0x80
#define MASK_E     0x79
#define MASK_R     0x50

static CalcState currentState = STATE_WAIT_A;
static uint8_t selectedOpIndex = 0;
static int16_t operandA = 0;
static int16_t operandB = 0;

#define ERROR_LED_ON()   (GPIOA->ODR |=  (1 << 5))
#define ERROR_LED_OFF()  (GPIOA->ODR &= ~(1 << 5))

void osSystickHandler(void) {
  tickCount++;
}

void initGPIO() {
  // Включаем тактирование GPIOA и GPIOB
  RCC->AHBENR |= RCC_AHBENR_GPIOAEN | RCC_AHBENR_GPIOBEN;

  // Настраиваем PA5 как выход
  GPIOA->MODER = (GPIOA->MODER & ~(3 << 10)) | (1 << 10);
  GPIOA->OTYPER &= ~(1 << 5);
  GPIOA->OSPEEDR |= (1 << 10);
}

void initUSART2() {
  // Включаем тактирование USART2
  RCC->APB1ENR |= RCC_APB1ENR_USART2EN;

  // Настраиваем PA2 и PA3 в альтернативный режим
  GPIOA->MODER = (GPIOA->MODER & ~(0xF << 4)) | (0xA << 4);
  GPIOA->AFR[0] = (GPIOA->AFR[0] & ~(0xFF << 8)) | (1 << 8) | (1 << 12);

  // Настраиваем USART2
  USART2->BRR = 417; // 48MHz/115200
  USART2->CR1 = USART_CR1_TE | USART_CR1_UE;
}

void initSysTick() {
  SysTick->LOAD = 47999; // 1ms при 48MHz
  SysTick->VAL = 0;
  SysTick->CTRL = (1 << 2) | (1 << 1) | (1 << 0);
}

int _write(int file, uint8_t *ptr, int len) {
  for (int i = 0; i < len; i++) {
    while (!(USART2->ISR & USART_ISR_TXE));
    USART2->TDR = ptr[i];
  }
  return len;
}

static void systemReset(void) {
  currentState = STATE_WAIT_A;

  operandA = 0;
  operandB = 0;

  selectedOpIndex = 0;
  ERROR_LED_OFF();
  tm1637_clear();
}

static void renderBuffer(const uint8_t buf[4]) {
  tm1637_start();
  tm1637_write_byte(TM1637_CMD1);
  tm1637_stop();

  tm1637_start();
  tm1637_write_byte(TM1637_CMD2);

  for (uint8_t i = 0; i < 4; ++i) {
    tm1637_write_byte(buf[i]);
  }

  tm1637_stop();

  tm1637_start();
  tm1637_write_byte(TM1637_CMD3);
  tm1637_stop();
}

static void renderError(void) {
  uint8_t errBuf[4] = { MASK_BLANK, MASK_E, MASK_R, MASK_R };
  renderBuffer(errBuf);

  ERROR_LED_ON();
}

static void renderInteger(int16_t value) {
  uint8_t digits[4] = { MASK_BLANK, MASK_BLANK, MASK_BLANK, MASK_BLANK };

  uint8_t isNegative = (value < 0);
  uint16_t absValue = isNegative ? (-value) : value;

  int pos = 3;

  do {
    digits[pos--] = DIGIT_MAP[absValue % 10];
    absValue /= 10;
  } while (absValue > 0 && pos >= 0);

  if (isNegative && pos >= 0) {
    digits[pos] = MASK_MINUS;
  }

  renderBuffer(digits);
}

static void renderFloat2Dec(uint16_t fixedPoint) {
  uint8_t digits[4];

  digits[0] = MASK_BLANK;
  digits[1] = DIGIT_MAP[(fixedPoint / 100) % 10] | MASK_DOT;
  digits[2] = DIGIT_MAP[(fixedPoint / 10) % 10];
  digits[3] = DIGIT_MAP[fixedPoint % 10];

  renderBuffer(digits);
}

static void calculateResult(void) {
  currentState = STATE_SHOW_RESULT;

  char op = MATH_OPS[selectedOpIndex];

  if (op == '/') {
    if (operandB == 0) {
      renderError();
      printf("[Error]: Division by zero\n");
      
      return;
    }

    // Храним 2 знака после запятой
    uint16_t fixedPoint = (uint16_t)((operandA * 100) + (operandB / 2)) / operandB;
    renderFloat2Dec(fixedPoint);

    printf("%d / %d = %u.%02u\n", operandA, operandB, fixedPoint / 100, fixedPoint % 100);

    return;
  }

  int16_t ans = 0;

  switch (op) {
    case '+': ans = operandA + operandB; break;
    case '-': ans = operandA - operandB; break;
    case '*': ans = operandA * operandB; break;
  }

  renderInteger(ans);
  printf("%d %c %d = %d\n", operandA, op, operandB, ans);
}

static void processKeyPress(char key) {
  if (currentState == STATE_SHOW_RESULT && key != '#') {
    systemReset();
  }

  if (key >= '0' && key <= '9') {
    if (currentState == STATE_WAIT_A) {
      operandA = key - '0';
      renderInteger(operandA);
    } else {
      currentState = STATE_WAIT_B;
      operandB = key - '0';
      renderInteger(operandB);
    }
  } else if (key == '*') {
    if (currentState == STATE_WAIT_A) {
      currentState = STATE_SELECT_OP;
      selectedOpIndex = 0;
    } else {
      selectedOpIndex = (selectedOpIndex + 1) % 4;
    }

    printf("Selected op: %c\n", MATH_OPS[selectedOpIndex]);
  } else if (key == '#' && currentState == STATE_WAIT_B) {
    calculateResult();
  }
}

int main(void) {
  initGPIO();
  initUSART2();
  initSysTick();
  initKeyboard();
  tm1637_init();

  systemReset();

  printf("Enter: [Digit1] [*...] [Digit2] [#]\n");

  while (1) {
    scanKeyboard();

    if (lastKey != previousKey) {
      previousKey = lastKey;

      if (lastKey != 0) {
        processKeyPress(lastKey);
      }
    }
  }

  return 0;
}