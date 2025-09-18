parser grammar ParseRules;
// grammar for basic calculator language

tokens {TILDE, OP, BOOL, PRINT, INPUT, REV, LIT, ID, IGNORE}

program
    : stat program #NonEmptyProg
    | EOF #EmptyProg
    ;

stat
    : PRINT expr
    | ID TILDE expr
    ;

expr
    : LIT
    | BOOL
    | expr OP expr
    | INPUT
    | REV TILDE expr TILDE
    | ID
    ;