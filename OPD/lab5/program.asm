ORG 0x555
ARRAY:  WORD 0xD2D5
        WORD 0xE0D5
        WORD 0xD7D0
        WORD 0x280A

ORG 0x20
ADDR: WORD $ARRAY       ; string address
I: WORD 0               ; current chars of the string
BUFF: WORD 0            ; buffer cell
STOP_C: WORD 0x0A       ; EOF char

START:  CLA             ; clear
        LD ADDR         
        ST I            ; I = ADDR

S1:
    LD (I)+             ; increment of the pointer to the current chars
    ST BUFF             ; load 2 chars (2 chars in one cell) into a buffer cell (BUFF)
    SWAB                ; \
    SXTB                ;  -> sign extension (get the first char)
    CMP STOP_C          ; compare with the stop char (STOP_C)
    BEQ STOP            ; if equal, then end the output
    
    CALL $PRINT_CH

S2:
    LD BUFF             ; load the buffer cell
    SXTB                ; sign extension (get the second char)
    CMP STOP_C          ; compare with the stop char (STOP_C)
    BEQ STOP            ; if equal, then end the output

    CALL $PRINT_CH

    JUMP S1             ; move on to the output of a new cell (2 chars)

PRINT_CH:
    CALL $PRINT_CH_SMALL_GROUP_1
    CALL $PRINT_CH_SMALL_GROUP_2
    CALL $PRINT_CH_SMALL_GROUP_3
    CALL $PRINT_CH_SMALL_GROUP_4

    CALL $PRINT_CH_BIG_GROUP_1
    CALL $PRINT_CH_BIG_GROUP_2
    CALL $PRINT_CH_BIG_GROUP_3
    CALL $PRINT_CH_BIG_GROUP_4

    CALL $PRINT_SYMBOL_GROUP_1
    CALL $PRINT_SYMBOL_GROUP_2

    RET

STOP:   HLT             ; exit program

PRINT_BIG_LET_30:
    CALL $BIG_LET_30
    RET

PRINT_BIG_LET_31:
    CALL $BIG_LET_31
    RET

PRINT_BIG_LET_32:
    CALL $BIG_LET_32
    RET

PRINT_BIG_LET_33:
    CALL $BIG_LET_33
    RET

PRINT_CH_BIG_GROUP_1:
    CMP #0xCC
    BEQ PRINT_BIG_LET_30

    CMP #0xCD
    BEQ PRINT_BIG_LET_31

    CMP #0xCE
    BEQ PRINT_BIG_LET_32

    CMP #0xCF
    BEQ PRINT_BIG_LET_33
    

    CMP #0xB0
    BEQ PRINT_BIG_LET_1

    CMP #0xB1
    BEQ PRINT_BIG_LET_2

    CMP #0xB2
    BEQ PRINT_BIG_LET_3

    CMP #0xB3
    BEQ PRINT_BIG_LET_4

    RET

PRINT_BIG_LET_1:
    CALL $BIG_LET_1
    RET

PRINT_BIG_LET_2:
    CALL $BIG_LET_2
    RET

PRINT_BIG_LET_3:
    CALL $BIG_LET_3
    RET

PRINT_BIG_LET_4:
    CALL $BIG_LET_4
    RET

PRINT_BIG_LET_5:
    CALL $BIG_LET_5
    RET

PRINT_BIG_LET_6_7:
    CALL $BIG_LET_6_7
    RET

PRINT_BIG_LET_8:
    CALL $BIG_LET_8
    RET

PRINT_BIG_LET_9:
    CALL $BIG_LET_9
    RET

PRINT_CH_BIG_GROUP_2:
    CMP #0xB4
    BEQ PRINT_BIG_LET_5

    CMP #0xB5
    BEQ PRINT_BIG_LET_6_7

    CMP #0xB6
    BEQ PRINT_BIG_LET_8

    CMP #0xB7
    BEQ PRINT_BIG_LET_9

    CMP #0xB8
    BEQ PRINT_BIG_LET_10_11

    CMP #0xB9
    BEQ PRINT_BIG_LET_10_11

    CMP #0xBA
    BEQ PRINT_BIG_LET_12

    CMP #0xBB
    BEQ PRINT_BIG_LET_13

    RET

PRINT_BIG_LET_10_11:
    CALL $BIG_LET_10_11
    RET

PRINT_BIG_LET_12:
    CALL $BIG_LET_12
    RET

PRINT_BIG_LET_13:
    CALL $BIG_LET_13
    RET

PRINT_BIG_LET_14:
    CALL $BIG_LET_14
    RET

PRINT_BIG_LET_15:
    CALL $BIG_LET_15
    RET

PRINT_BIG_LET_16:
    CALL $BIG_LET_16
    RET

PRINT_BIG_LET_17:
    CALL $BIG_LET_17
    RET

PRINT_CH_BIG_GROUP_3:
    CMP #0xBC
    BEQ PRINT_BIG_LET_14

    CMP #0xBD
    BEQ PRINT_BIG_LET_15

    CMP #0xBE
    BEQ PRINT_BIG_LET_16

    CMP #0xBF
    BEQ PRINT_BIG_LET_17

    CMP #0xC0
    BEQ PRINT_BIG_LET_18

    CMP #0xC1
    BEQ PRINT_BIG_LET_19

    CMP #0xC2
    BEQ PRINT_BIG_LET_20

    CMP #0xC3
    BEQ PRINT_BIG_LET_21

    RET

PRINT_BIG_LET_18:
    CALL $BIG_LET_18
    RET

PRINT_BIG_LET_19:
    CALL $BIG_LET_19
    RET

PRINT_BIG_LET_20:
    CALL $BIG_LET_20
    RET

PRINT_BIG_LET_21:
    CALL $BIG_LET_21
    RET

PRINT_BIG_LET_22:
    CALL $BIG_LET_22
    RET

PRINT_BIG_LET_23:
    CALL $BIG_LET_23
    RET

PRINT_BIG_LET_24:
    CALL $BIG_LET_24
    RET

PRINT_BIG_LET_25:
    CALL $BIG_LET_25
    RET

PRINT_CH_BIG_GROUP_4:
    CMP #0xC4
    BEQ PRINT_BIG_LET_22

    CMP #0xC5
    BEQ PRINT_BIG_LET_23

    CMP #0xC6
    BEQ PRINT_BIG_LET_24

    CMP #0xC7
    BEQ PRINT_BIG_LET_25

    CMP #0xC8
    BEQ PRINT_BIG_LET_26

    CMP #0xC9
    BEQ PRINT_BIG_LET_27

    CMP #0xCA
    BEQ PRINT_BIG_LET_28

    CMP #0xCB
    BEQ PRINT_BIG_LET_29

    RET

PRINT_BIG_LET_26:
    CALL $BIG_LET_26
    RET

PRINT_BIG_LET_27:
    CALL $BIG_LET_27
    RET

PRINT_BIG_LET_28:
    CALL $BIG_LET_28
    RET

PRINT_BIG_LET_29:
    CALL $BIG_LET_29
    RET

; SMALL

PRINT_SMALL_LET_1:
    CALL $SMALL_LET_1
    RET

PRINT_SMALL_LET_2:
    CALL $SMALL_LET_2
    RET

PRINT_SMALL_LET_3:
    CALL $SMALL_LET_3
    RET

PRINT_SMALL_LET_4:
    CALL $SMALL_LET_4
    RET

PRINT_CH_SMALL_GROUP_1:
    CMP #0xD0
    BEQ PRINT_SMALL_LET_1

    CMP #0xD1
    BEQ PRINT_SMALL_LET_2

    CMP #0xD2
    BEQ PRINT_SMALL_LET_3

    CMP #0xD3
    BEQ PRINT_SMALL_LET_4


    CMP #0xD4
    BEQ PRINT_SMALL_LET_5

    CMP #0xD5
    BEQ PRINT_SMALL_LET_6_7

    CMP #0xD6
    BEQ PRINT_SMALL_LET_8

    CMP #0xD7
    BEQ PRINT_SMALL_LET_9

    RET

PRINT_SMALL_LET_5:
    CALL $SMALL_LET_5
    RET

PRINT_SMALL_LET_6_7:
    CALL $SMALL_LET_6_7
    RET

PRINT_SMALL_LET_8:
    CALL $SMALL_LET_8
    RET

PRINT_SMALL_LET_9:
    CALL $SMALL_LET_9
    RET

PRINT_SMALL_LET_10_11:
    CALL $SMALL_LET_10_11
    RET

PRINT_SMALL_LET_12:
    CALL $SMALL_LET_12
    RET

PRINT_SMALL_LET_13:
    CALL $SMALL_LET_13
    RET

PRINT_CH_SMALL_GROUP_2:
    CMP #0xD8
    BEQ PRINT_SMALL_LET_10_11

    CMP #0xD9
    BEQ PRINT_SMALL_LET_10_11

    CMP #0xDA
    BEQ PRINT_SMALL_LET_12

    CMP #0xDB
    BEQ PRINT_SMALL_LET_13


    CMP #0xDC
    BEQ PRINT_SMALL_LET_14

    CMP #0xDD
    BEQ PRINT_SMALL_LET_15

    CMP #0xDE
    BEQ PRINT_SMALL_LET_16

    CMP #0xDF
    BEQ PRINT_SMALL_LET_17

    RET

PRINT_SMALL_LET_14:
    CALL $SMALL_LET_14
    RET

PRINT_SMALL_LET_15:
    CALL $SMALL_LET_15
    RET

PRINT_SMALL_LET_16:
    CALL $SMALL_LET_16
    RET

PRINT_SMALL_LET_17:
    CALL $SMALL_LET_17
    RET

PRINT_SMALL_LET_18:
    CALL $SMALL_LET_18
    RET

PRINT_SMALL_LET_19:
    CALL $SMALL_LET_19
    RET

PRINT_SMALL_LET_20:
    CALL $SMALL_LET_20
    RET

PRINT_SMALL_LET_21:
    CALL $SMALL_LET_21
    RET

PRINT_CH_SMALL_GROUP_3:
    CMP #0xE0
    BEQ PRINT_SMALL_LET_18

    CMP #0xE1
    BEQ PRINT_SMALL_LET_19

    CMP #0xE2
    BEQ PRINT_SMALL_LET_20

    CMP #0xE3
    BEQ PRINT_SMALL_LET_21


    CMP #0xE4
    BEQ PRINT_SMALL_LET_22

    CMP #0xE5
    BEQ PRINT_SMALL_LET_23

    CMP #0xE6
    BEQ PRINT_SMALL_LET_24

    CMP #0xE7
    BEQ PRINT_SMALL_LET_25

    RET

PRINT_SMALL_LET_22:
    CALL $SMALL_LET_22
    RET

PRINT_SMALL_LET_23:
    CALL $SMALL_LET_23
    RET

PRINT_SMALL_LET_24:
    CALL $SMALL_LET_24
    RET

PRINT_SMALL_LET_25:
    CALL $SMALL_LET_25
    RET

PRINT_SMALL_LET_26:
    CALL $SMALL_LET_26
    RET

PRINT_SMALL_LET_27:
    CALL $SMALL_LET_27
    RET

PRINT_SMALL_LET_28:
    CALL $SMALL_LET_28
    RET

PRINT_SMALL_LET_29:
    CALL $SMALL_LET_29
    RET

PRINT_CH_SMALL_GROUP_4:
    CMP #0xE8
    BEQ PRINT_SMALL_LET_26

    CMP #0xE9
    BEQ PRINT_SMALL_LET_27

    CMP #0xEA
    BEQ PRINT_SMALL_LET_28

    CMP #0xEB
    BEQ PRINT_SMALL_LET_29


    CMP #0xEC
    BEQ PRINT_SMALL_LET_30

    CMP #0xED
    BEQ PRINT_SMALL_LET_31

    CMP #0xEE
    BEQ PRINT_SMALL_LET_32

    CMP #0xEF
    BEQ PRINT_SMALL_LET_33

    RET

PRINT_SMALL_LET_30:
    CALL $SMALL_LET_30
    RET

PRINT_SMALL_LET_31:
    CALL $SMALL_LET_31
    RET

PRINT_SMALL_LET_32:
    CALL $SMALL_LET_32
    RET

PRINT_SMALL_LET_33:
    CALL $SMALL_LET_33
    RET

SMALL_LET_1: ; буква а
    LD #0x1C
    OUT 0x10
    LD #0x28
    OUT 0x10
    LD #0x1C
    OUT 0x10
    LD #0x00
    OUT 0x10
    RET



BIG_LET_1: ; буква А
    LD #0x7C
    OUT 0x10
    LD #0x90
    OUT 0x10
    LD #0x7C
    OUT 0x10
    LD #0x00
    OUT 0x10
    RET

SMALL_LET_2: ; буква б
    LD #0x3C
    OUT 0x10
    LD #0x2C
    OUT 0x10
    LD #0x2C
    OUT 0x10
    LD #0x00
    OUT 0x10
    RET

BIG_LET_2: ; буква Б
    LD #0x7C
    OUT 0x10
    LD #0x54
    OUT 0x10
    LD #0x5C
    OUT 0x10
    LD #0x00
    OUT 0x10
    RET

SMALL_LET_3: ; буква в
    LD #0x3C
    OUT 0x10
    LD #0x2C
    OUT 0x10
    LD #0x34
    OUT 0x10
    LD #0x00
    OUT 0x10
    RET

BIG_LET_3: ; буква B
    LD #0x7C
    OUT 0x10
    LD #0x54
    OUT 0x10
    LD #0x6C
    OUT 0x10
    LD #0x00
    OUT 0x10
    RET

SMALL_LET_4:  ; буква г
    LD #0x3C
    OUT 0x10
    LD #0x20
    OUT 0x10
    LD #0x20
    OUT 0x10
    LD #0x00
    OUT 0x10
    RET

BIG_LET_4: ; буква Г
    LD #0x7C
    OUT 0x10
    LD #0x40
    OUT 0x10
    LD #0x40
    OUT 0x10
    LD #0x00
    OUT 0x10
    RET

SMALL_LET_5:  ; буква д
    LD #0x0C
    OUT 0x10
    LD #0x38
    OUT 0x10
    LD #0x38
    OUT 0x10
    LD #0x0C
    OUT 0x10
    LD #0x00
    OUT 0x10
    RET

BIG_LET_5: ; буква Д
    LD #0x04
    OUT 0x10
    LD #0x78
    OUT 0x10
    LD #0x48
    OUT 0x10
    LD #0x78
    OUT 0x10
    LD #0x00
    OUT 0x10
    RET

SMALL_LET_6_7: ; буква e
    LD #0x3C
    OUT 0x10
    LD #0x2C
    OUT 0x10
    LD #0x34
    OUT 0x10
    LD #0x00
    OUT 0x10
    RET

BIG_LET_6_7: ; буква Е
    LD #0x7C
    OUT 0x10
    LD #0x54
    OUT 0x10
    LD #0x54
    OUT 0x10
    LD #0x00
    OUT 0x10
    RET

SMALL_LET_8: ; буква ж
    LD #0x24
    OUT 0x10
    LD #0x18
    OUT 0x10
    LD #0x3C
    OUT 0x10
    LD #0x18
    OUT 0x10
    LD #0x24
    OUT 0x10
    LD #0x00
    OUT 0x10
    RET

BIG_LET_8: ; буква Ж
    LD #0x44
    OUT 0x10
    LD #0x28
    OUT 0x10
    LD #0x7C
    OUT 0x10
    LD #0x28
    OUT 0x10
    LD #0x44
    OUT 0x10
    LD #0x00
    OUT 0x10
    RET

SMALL_LET_9: ; буква з
    LD #0x2C
    OUT 0x10
    LD #0x2C
    OUT 0x10
    LD #0x3C
    OUT 0x10
    LD #0x00
    OUT 0x10
    RET

BIG_LET_9: ; буква З
    LD #0x54
    OUT 0x10
    LD #0x54
    OUT 0x10
    LD #0x7C
    OUT 0x10
    LD #0x00
    OUT 0x10
    RET

SMALL_LET_10_11: ; буква и
    LD #0x3C
    OUT 0x10
    LD #0x08
    OUT 0x10
    LD #0x10
    OUT 0x10
    LD #0x3C
    OUT 0x10
    LD #0x00
    OUT 0x10
    RET

BIG_LET_10_11: ; буква И
    LD #0x7C
    OUT 0x10
    LD #0x08
    OUT 0x10
    LD #0x10
    OUT 0x10
    LD #0x20
    OUT 0x10
    LD #0x7C
    OUT 0x10
    LD #0x00
    OUT 0x10
    RET

SMALL_LET_12:  ; буква к
    LD #0x3C
    OUT 0x10
    LD #0x18
    OUT 0x10
    LD #0x24
    OUT 0x10
    LD #0x00
    OUT 0x10
    RET

BIG_LET_12: ; буква К
    LD #0x7C
    OUT 0x10
    LD #0x10
    OUT 0x10
    LD #0x28
    OUT 0x10
    LD #0x44
    OUT 0x10
    LD #0x00
    OUT 0x10
    RET

SMALL_LET_13:  ; буква л
    LD #0x1C
    OUT 0x10
    LD #0x20
    OUT 0x10
    LD #0x1C
    OUT 0x10
    LD #0x00
    OUT 0x10
    RET

BIG_LET_13: ; буква Л
    LD #0x3C
    OUT 0x10
    LD #0x40
    OUT 0x10
    LD #0x3C
    OUT 0x10
    LD #0x00
    OUT 0x10
    RET

SMALL_LET_14:  ; буква м
    LD #0x3C
    OUT 0x10
    LD #0x10
    OUT 0x10
    LD #0x3C
    OUT 0x10
    LD #0x00
    OUT 0x10
    RET

BIG_LET_14: ; буква М
    LD #0x7C
    OUT 0x10
    LD #0x20
    OUT 0x10
    LD #0x10
    OUT 0x10
    LD #0x20
    OUT 0x10
    LD #0x7C
    OUT 0x10
    LD #0x00
    OUT 0x10
    RET

SMALL_LET_15:  ; буква н
    LD #0x3C
    OUT 0x10
    LD #0x10
    OUT 0x10
    LD #0x3C
    OUT 0x10
    LD #0x00
    OUT 0x10
    RET

BIG_LET_15: ; буква Н
    LD #0x7C
    OUT 0x10
    LD #0x10
    OUT 0x10
    LD #0x7C
    OUT 0x10
    LD #0x00
    OUT 0x10
    RET

SMALL_LET_16:  ; буква о
    LD #0x18
    OUT 0x10
    LD #0x24
    OUT 0x10
    LD #0x18
    OUT 0x10
    LD #0x00
    OUT 0x10
    RET

BIG_LET_16: ; буква О
    LD #0x7C
    OUT 0x10
    LD #0x44
    OUT 0x10
    LD #0x7C
    OUT 0x10
    LD #0x00
    OUT 0x10
    RET

SMALL_LET_17:  ; буква п
    LD #0x3C
    OUT 0x10
    LD #0x20
    OUT 0x10
    LD #0x3C
    OUT 0x10
    LD #0x00
    OUT 0x10
    RET

BIG_LET_17: ; буква П
    LD #0x7C
    OUT 0x10
    LD #0x40
    OUT 0x10
    LD #0x7C
    OUT 0x10
    LD #0x00
    OUT 0x10
    RET

SMALL_LET_18:  ; буква р
    LD #0x3C
    OUT 0x10
    LD #0x28
    OUT 0x10
    LD #0x30
    OUT 0x10
    LD #0x00
    OUT 0x10
    RET

BIG_LET_18: ; буква Р
    LD #0x7C
    OUT 0x10
    LD #0x50
    OUT 0x10
    LD #0x70
    OUT 0x10
    LD #0x00
    OUT 0x10
    RET

SMALL_LET_19:  ; буква с
    LD #0x18
    OUT 0x10
    LD #0x24
    OUT 0x10
    LD #0x24
    OUT 0x10
    LD #0x00
    OUT 0x10
    RET

BIG_LET_19: ; буква С
    LD #0x7C
    OUT 0x10
    LD #0x44
    OUT 0x10
    LD #0x44
    OUT 0x10
    LD #0x00
    OUT 0x10
    RET

SMALL_LET_20:  ; буква т
    LD #0x20
    OUT 0x10
    LD #0x3C
    OUT 0x10
    LD #0x20
    OUT 0x10
    LD #0x00
    OUT 0x10
    RET

BIG_LET_20: ; буква Т
    LD #0x40
    OUT 0x10
    LD #0x7C
    OUT 0x10
    LD #0x40
    OUT 0x10
    LD #0x00
    OUT 0x10
    RET

SMALL_LET_21: ; буква у
    LD #0x34
    OUT 0x10
    LD #0x14
    OUT 0x10
    LD #0x3C
    OUT 0x10
    LD #0x00
    OUT 0x10
    RET

BIG_LET_21: ; буква У
    LD #0x74
    OUT 0x10
    LD #0x14
    OUT 0x10
    LD #0x7C
    OUT 0x10
    LD #0x00
    OUT 0x10
    RET

SMALL_LET_22: ; буква ф
    LD #0x18
    OUT 0x10
    LD #0x3C
    OUT 0x10
    LD #0x18
    OUT 0x10
    LD #0x00
    OUT 0x10
    RET

BIG_LET_22: ; буква Ф
    LD #0x10
    OUT 0x10
    LD #0x28
    OUT 0x10
    LD #0x7C
    OUT 0x10
    LD #0x28
    OUT 0x10
    LD #0x10
    OUT 0x10
    LD #0x00
    OUT 0x10
    RET

SMALL_LET_23: ; буква х
    LD #0x24
    OUT 0x10
    LD #0x18
    OUT 0x10
    LD #0x18
    OUT 0x10
    LD #0x24
    OUT 0x10
    LD #0x00
    OUT 0x10
    RET

BIG_LET_23: ; буква Х
    LD #0x44
    OUT 0x10
    LD #0x28
    OUT 0x10
    LD #0x10
    OUT 0x10
    LD #0x28
    OUT 0x10
    LD #0x44
    OUT 0x10
    LD #0x00
    OUT 0x10
    RET

SMALL_LET_24: ; буква ц
    LD #0x3C
    OUT 0x10
    LD #0x08
    OUT 0x10
    LD #0x38
    OUT 0x10
    LD #0x00
    OUT 0x10
    RET

BIG_LET_24: ; буква Ц
    LD #0x7C
    OUT 0x10
    LD #0x04
    OUT 0x10
    LD #0x7C
    OUT 0x10
    LD #0x04
    OUT 0x10
    LD #0x00
    OUT 0x10
    RET

SMALL_LET_25: ; буква ч
    LD #0x30
    OUT 0x10
    LD #0x10
    OUT 0x10
    LD #0x3C
    OUT 0x10
    LD #0x00
    OUT 0x10
    RET

BIG_LET_25: ; буква Ч
    LD #0x70
    OUT 0x10
    LD #0x10
    OUT 0x10
    LD #0x7C
    OUT 0x10
    LD #0x00
    OUT 0x10
    RET

SMALL_LET_26: ; буква ш
    LD #0x3C
    OUT 0x10
    LD #0x04
    OUT 0x10
    LD #0x3C
    OUT 0x10
    LD #0x04
    OUT 0x10
    LD #0x3C
    OUT 0x10
    LD #0x00
    OUT 0x10
    RET

BIG_LET_26: ; буква Ш
    LD #0x7C
    OUT 0x10
    LD #0x04
    OUT 0x10
    LD #0x7C
    OUT 0x10
    LD #0x04
    OUT 0x10
    LD #0x7C
    OUT 0x10
    LD #0x00
    OUT 0x10
    RET

SMALL_LET_27: ; буква щ
    LD #0x3C
    OUT 0x10
    LD #0x04
    OUT 0x10
    LD #0x3C
    OUT 0x10
    LD #0x04
    OUT 0x10
    LD #0x3C
    OUT 0x10
    LD #0x04
    OUT 0x10
    LD #0x00
    OUT 0x10
    RET

BIG_LET_27: ; буква Щ
    LD #0x7C
    OUT 0x10
    LD #0x04
    OUT 0x10
    LD #0x7C
    OUT 0x10
    LD #0x04
    OUT 0x10
    LD #0x7C
    OUT 0x10
    LD #0x04
    OUT 0x10
    LD #0x00
    OUT 0x10
    RET

SMALL_LET_28: ; буква ъ
    LD #0x20
    OUT 0x10
    LD #0x3C
    OUT 0x10
    LD #0x14
    OUT 0x10
    LD #0x0C
    OUT 0x10
    LD #0x00
    OUT 0x10
    RET

BIG_LET_28: ; буква Ъ
    LD #0x40
    OUT 0x10
    LD #0x7C
    OUT 0x10
    LD #0x14
    OUT 0x10
    LD #0x1C
    OUT 0x10
    LD #0x00
    OUT 0x10
    RET

SMALL_LET_29: ; буква ы
    LD #0x3C
    OUT 0x10
    LD #0x00
    OUT 0x10
    LD #0x3C
    OUT 0x10
    LD #0x14
    OUT 0x10
    LD #0x0C
    OUT 0x10
    LD #0x00
    OUT 0x10
    RET

BIG_LET_29: ; буква Ы
    LD #0x7C
    OUT 0x10
    LD #0x00
    OUT 0x10
    LD #0x7C
    OUT 0x10
    LD #0x14
    OUT 0x10
    LD #0x1C
    OUT 0x10
    LD #0x00
    OUT 0x10
    RET

SMALL_LET_30: ; буква ь
    LD #0x3C
    OUT 0x10
    LD #0x14
    OUT 0x10
    LD #0x0C
    OUT 0x10
    LD #0x00
    OUT 0x10
    RET

BIG_LET_30: ; буква Ь
    LD #0x7C
    OUT 0x10
    LD #0x14
    OUT 0x10
    LD #0x1C
    OUT 0x10
    LD #0x00
    OUT 0x10
    RET

SMALL_LET_31: ; буква э
    LD #0x2C
    OUT 0x10
    LD #0x2C
    OUT 0x10
    LD #0x2C
    OUT 0x10
    LD #0x18
    OUT 0x10
    LD #0x00
    OUT 0x10
    RET

BIG_LET_31: ; буква Э
    LD #0x54
    OUT 0x10
    LD #0x54
    OUT 0x10
    LD #0x54
    OUT 0x10
    LD #0x38
    OUT 0x10
    LD #0x00
    OUT 0x10
    RET

SMALL_LET_32: ; буква ю
    LD #0x3C
    OUT 0x10
    LD #0x18
    OUT 0x10
    LD #0x3C
    OUT 0x10
    LD #0x24
    OUT 0x10
    LD #0x3C
    OUT 0x10
    LD #0x00
    OUT 0x10
    RET

BIG_LET_32: ; буква Ю
    LD #0x7C
    OUT 0x10
    LD #0x18
    OUT 0x10
    LD #0x38
    OUT 0x10
    LD #0x44
    OUT 0x10
    LD #0x38
    OUT 0x10
    LD #0x00
    OUT 0x10
    RET

SMALL_LET_33: ; буква я
    LD #0x34
    OUT 0x10
    LD #0x28
    OUT 0x10
    LD #0x3C
    OUT 0x10
    LD #0x00
    OUT 0x10
    RET

BIG_LET_33: ; буква Я
    LD #0x74
    OUT 0x10
    LD #0x58
    OUT 0x10
    LD #0x50
    OUT 0x10
    LD #0x7C
    OUT 0x10
    LD #0x00
    OUT 0x10
    RET

PRINT_SYMBOL_1:
    CALL $SYMBOL_1
    RET

PRINT_SYMBOL_2:
    CALL $SYMBOL_2
    RET

PRINT_SYMBOL_3:
    CALL $SYMBOL_3
    RET

PRINT_SYMBOL_4:
    CALL $SYMBOL_4
    RET

PRINT_SYMBOL_GROUP_1:
    CMP #0x28
    BEQ PRINT_SYMBOL_1

    CMP #0x29
    BEQ PRINT_SYMBOL_2

    CMP #0x25
    BEQ PRINT_SYMBOL_3

    CMP #0x2A
    BEQ PRINT_SYMBOL_4


    CMP #0xF0
    BEQ PRINT_SYMBOL_5

    CMP #0x3F
    BEQ PRINT_SYMBOL_6

    CMP #0x21
    BEQ PRINT_SYMBOL_7

    CMP #0x3A
    BEQ PRINT_SYMBOL_8

    RET

PRINT_SYMBOL_5:
    CALL $SYMBOL_5
    RET

PRINT_SYMBOL_6:
    CALL $SYMBOL_6
    RET

PRINT_SYMBOL_7:
    CALL $SYMBOL_7
    RET

PRINT_SYMBOL_8:
    CALL $SYMBOL_8
    RET

PRINT_SYMBOL_9:
    CALL $SYMBOL_9
    RET

PRINT_SYMBOL_10:
    CALL $SYMBOL_10
    RET

PRINT_SYMBOL_11:
    CALL $SYMBOL_11
    RET

PRINT_SYMBOL_12:
    CALL $SYMBOL_12
    RET

PRINT_SYMBOL_GROUP_2:
    CMP #0x3B
    BEQ PRINT_SYMBOL_9

    CMP #0x2C
    BEQ PRINT_SYMBOL_10

    CMP #0x2D
    BEQ PRINT_SYMBOL_11

    CMP #0x2B
    BEQ PRINT_SYMBOL_12


    CMP #0x3D
    BEQ PRINT_SYMBOL_13
    
    CMP #0x2E
    BEQ PRINT_SYMBOL_14

    CMP #0x23
    BEQ PRINT_SYMBOL_15

    CMP #0x5F
    BEQ PRINT_SYMBOL_16

    RET

PRINT_SYMBOL_13:
    CALL $SYMBOL_13
    RET

PRINT_SYMBOL_14:
    CALL $SYMBOL_14
    RET

PRINT_SYMBOL_15:
    CALL $SYMBOL_15
    RET

PRINT_SYMBOL_16:
    CALL $SYMBOL_16
    RET

SYMBOL_1: ; символ '('
    LD #0x38
    OUT 0x10
    LD #0x44
    OUT 0x10
    LD #0x00
    OUT 0x10
    RET

SYMBOL_2: ; символ ')'
    LD #0x44
    OUT 0x10
    LD #0x38
    OUT 0x10
    LD #0x00
    OUT 0x10
    RET

SYMBOL_3: ; символ '%'
    LD #0x64
    OUT 0x10
    LD #0x68
    OUT 0x10
    LD #0x10
    OUT 0x10
    LD #0x2C
    OUT 0x10
    LD #0x4C
    OUT 0x10
    LD #0x00
    OUT 0x10
    RET

SYMBOL_4: ; символ '*'
    LD #0x54
    OUT 0x10
    LD #0x38
    OUT 0x10
    LD #0x7C
    OUT 0x10
    LD #0x38
    OUT 0x10
    LD #0x54
    OUT 0x10
    LD #0x00
    OUT 0x10
    RET

SYMBOL_5: ; символ '№'
    LD #0x3C
    OUT 0x10
    LD #0x10
    OUT 0x10
    LD #0x0C
    OUT 0x10
    LD #0xF0
    OUT 0x10
    LD #0x00
    OUT 0x10
    RET

SYMBOL_6: ; символ '?'
    LD #0x40
    OUT 0x10
    LD #0x94
    OUT 0x10
    LD #0x60
    OUT 0x10
    LD #0x00
    OUT 0x10
    RET

SYMBOL_7: ; символ '!'
    LD #0xF4
    OUT 0x10
    LD #0x00
    OUT 0x10
    RET

SYMBOL_8: ; символ ':'
    LD #0x28
    OUT 0x10
    LD #0x00
    OUT 0x10
    RET

SYMBOL_9: ; символ ';'
    LD #0x04
    OUT 0x10
    LD #0x2C
    OUT 0x10
    LD #0x00
    OUT 0x10
    RET

SYMBOL_10: ; символ ','
    LD #0x04
    OUT 0x10
    LD #0x0C
    OUT 0x10
    LD #0x00
    OUT 0x10
    RET

SYMBOL_11: ; символ '-'
    LD #0x10
    OUT 0x10
    LD #0x10
    OUT 0x10
    LD #0x10
    OUT 0x10
    LD #0x00
    OUT 0x10
    RET

SYMBOL_12: ; символ '+'
    LD #0x10
    OUT 0x10
    LD #0x31
    OUT 0x10
    LD #0x10
    OUT 0x10
    LD #0x00
    OUT 0x10
    RET

SYMBOL_13: ; символ '='
    LD #0x21
    OUT 0x10
    LD #0x21
    OUT 0x10
    LD #0x21
    OUT 0x10
    LD #0x00
    OUT 0x10
    RET

SYMBOL_14: ; символ '.'
    LD #0x01
    OUT 0x10
    LD #0x00
    OUT 0x10
    RET

SYMBOL_15: ; символ '#'
    LD #0x28
    OUT 0x10
    LD #0x7C
    OUT 0x10
    LD #0x28
    OUT 0x10
    LD #0x7C
    OUT 0x10
    LD #0x28
    OUT 0x10
    LD #0x00
    OUT 0x10
    RET

SYMBOL_16: ; символ '_'
    LD #0x04
    OUT 0x10
    LD #0x04
    OUT 0x10
    LD #0x04
    OUT 0x10
    LD #0x00
    OUT 0x10
    RET