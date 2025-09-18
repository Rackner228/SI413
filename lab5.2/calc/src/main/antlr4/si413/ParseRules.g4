parser grammar ParseRules;
// grammar for basic calculator language

tokens {TILDE, OP, BOOL, PRINT, INPUT, REV, LIT, ID, IGNORE}

program
  : stat program #ProgProg
  | EOF #EmptyProg
  ;

stat
  : PRINT expr #PrintStat
  | ID TILDE expr #IDStat
  ;

expr
  : LIT #LitExpr
  | BOOL #BoolExpr
  | expr OP expr #ExprExpr
  | INPUT #InputExpr
  | REV TILDE expr TILDE #RevExpr
  | ID #IDExpr
  ;