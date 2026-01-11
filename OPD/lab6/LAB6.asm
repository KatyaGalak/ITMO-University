ORG 0x0                         ; инициализация векторов прерывания
V0: WORD $DEFAULT, 0x180        ; вектор прерывания #0
V1: WORD $INT1, 0x180           ; вектор прерывания #1
V2: WORD $INT2, 0x180           ; вектор прерывания #2
V3: WORD $DEFAULT, 0x180        ; вектор прерывания #3
V4: WORD $DEFAULT, 0x180        ; вектор прерывания #4
V5: WORD $DEFAULT, 0x180        ; вектор прерывания #5
V6: WORD $DEFAULT, 0x180        ; вектор прерывания #6
V7: WORD $DEFAULT, 0x180        ; вектор прерывания #7

DEFAULT: IRET                   ; обработка прерывания по умолчанию

ORG 0x41
X: WORD ?
MIN_X: WORD 0xFFE0              ; -32
MAX_X: WORD 0x1F                ; 31

ORG 0x50
INT1:
    LD X 
    CALL CHECK
    PUSH                        ; сохраняем AC (кладем в стек) 
    ST X 
    NOP                         ; отладочная точка останова
    CLA 
    IN 0x4                      ; получаем значение РД ВУ-2
    SXTB
    SUB X                       ; (РД ВУ-2) - X
    CALL CHECK                  ; проверяем, не вышли ли за пределы ОДЗ, выполняя команду SUB X из РД ВУ-2 (если вышли X = MIN_X)
    ST X 
    NOP                         ; отладочная точка останова
    POP                         ; возвращаем значение AC (забираем из стека)
    IRET

INT2:
    LD X 
    CALL CHECK 
    PUSH                        ; сохраняем AC (кладем в стек) 
    ST X 
    NOP                         ; отладочная точка останова
    ASL                         ; 2X
    ASL                         ; 4X
    NEG                         ; -4X
    SUB #0x01                   ; -4X - 1
    OUT 0x6                     ; записываем AC по адресу в DR КВУ-3
    NOP                         ; отладочная точка останова
    POP                         ; возвращаем значение AC (забираем из стека)
    IRET

CHECK:
    CMP $MIN_X
    BLT LD_MIN
    CMP $MAX_X
    BEQ RETURN
    BGE LD_MIN
    JUMP RETURN
LD_MIN:
    LD $MIN_X
RETURN:
    RET 

ORG 0x75                        ; загрузка начальных векторов прерывания
START:
    DI
    CLA
    OUT 0x1
    OUT 0x3
    OUT 0xB
    OUT 0xE
    OUT 0x12
    OUT 0x16
    OUT 0x1A
    OUT 0x1E

    LD #0x9                     ; разрешение прерывания и вектор #1
    OUT 0x5                     ; (1000|0001) = 1001 в MR КВУ-2

    LD #0xA                     ; разрешение прерывания и вектор #2
    OUT 0x7                     ; (1000|0001) = 1001 в MR КВУ-3

    CLA
    EI
    JUMP MAIN

MAIN:
    DI
    LD X 
    ADD #0x2
    CALL CHECK
    ST X 
    EI
    JUMP MAIN 

