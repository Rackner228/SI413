Rranscript: Input Questions & Answers

You (initial code):

public String visitInputExpr(ParseRules.InputExpr ctx) {
    Scanner input = new Scanner(System.in);
    String name = input.nextLine();
    return name;
}


Error you got (Maven):

cannot find symbol
symbol:   class InputExpr
location: class si413.ParseRules


My response:

The error happened because your grammar (ParseRules.g4) didn’t have a rule named InputExpr.

Once you added | INPUT #InputExpr in your expr rule, ANTLR generated ParseRules.InputExprContext.

You needed to change your visitor signature to:

@Override
public String visitInputExpr(ParseRules.InputExprContext ctx) {
    return stdin.nextLine();
}


You (later):

public String visitInputExpr(ParseRules.InputExpr ctx) {
    Scanner input = new Scanner(System.in);
    String name = input.nextLine();
    return name;
}


My correction:

Don’t create a new Scanner each time, reuse your field:

private Scanner stdin = new Scanner(System.in);


Then:

@Override
public String visitInputExpr(ParseRules.InputExprContext ctx) {
    return stdin.nextLine();
}


Summary I gave you about grammar:

The InputExprContext is generated because your grammar has:

expr
  : INPUT #InputExpr
  ;


ctx.INPUT().getText() would just give you "i".

visit(ctx.expr()) doesn’t apply here, because there’s no nested expression.

The correct action is to pause for input using stdin.nextLine() and return that string.

Final Recommendation:
Keep a single Scanner stdin = new Scanner(System.in); as a field, and implement:
