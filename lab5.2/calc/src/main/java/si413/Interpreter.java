package si413;

import java.nio.file.Path;
import java.io.IOException;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import org.antlr.v4.runtime.TokenStream;
import java.util.HashMap;
import java.util.Map;

/** Interpreter for basic calculator language.
 * The tokens and grammar come from src/main/resource/si413/tokenSpec.txt
 * and src/main/antlr4/si413/ParseRules.g4 respectively.
 */

public class Interpreter {
    /** Methods in this class will execute statements.
     * Return type is Void because statements do not return anything.
     * Note that this is Void and not void, so we still have to return null
     * in each function. (This is a consequence of Java generics.)
     */
    private class StatementVisitor extends ParseRulesBaseVisitor<Void> {
        public Void visitRegularProg() {
            return null;
        }

        public Void visitPrintStat(ParseRules.PrintStatContext ctx) {

            String value = evisitor.visit(ctx.expr());      
            System.out.println(value);       
            return null; 
        }

        public Void visitIDStat(ParseRules.IDStatContext ctx) {
            String ID = ctx.ID().getText();
            String savedValue = evisitor.visit(ctx.expr());
            variables_stored.put(ID, savedValue);
            return null;
        }
    }

    /** Methods in this class will execute expressions and return the result.
     */
    private class ExpressionVisitor extends ParseRulesBaseVisitor<String> {
        public String visitLitExpr(ParseRules.LitExprContext ctx) {
            String word = ctx.LIT().getText();
            word = word.replace("[", "");
            word = word.replace("]", "");
            return word;
        }

        public String visitBoolExpr(ParseRules.BoolExprContext ctx) {
            String flag = ctx.BOOL().getText();
            return flag;
        }

        public String visitExprExpr(ParseRules.ExprExprContext ctx) {
            String left = visit(ctx.expr(0));
            String right = visit(ctx.expr(1));
            String op = ctx.OP().getText();
            // If statement to determine what operater it is \
            // OP: <|>|\?|\+|&|\|
            if (op.equals("+")) {
                String combined = left + right;
                return combined;
            }
            else if (op.equals(">")){
                if (left.compareTo(right) < 0) {
                    return "1";
                }
                else {
                    return "0";
                }
            }
            else if (op.equals("<")){
                if (left.compareTo(right) < 0){
                    return "1";
                }
                else {
                    return "0";
                }
            }
            else if (op.equals("&")){
                if(left.equals("1") && right.equals("1")) {
                    return "1";
                }
                else {
                    return "0";
                }
            }
            else if (op.equals("|")){
                if(left.equals("1") || right.equals("1")) {
                    return "1";
                }
                else {
                    return "0";
                }
            }
            else if (op.equals("?")) {
                if (right.contains(left)) {
                    return "1";
                } 
                else {
                    return "0";
                }

            }
            return null;
        }

        public String visitInputExpr(ParseRules.InputExprContext ctx) {
            Scanner input = new Scanner(System.in);
            String name = input.nextLine();
            return name;
        }

        public String visitRevExpr(ParseRules.RevExprContext ctx) {
            String word = visit(ctx.expr());
            char ch;
            String r = ""; // String that will store the rez`verse
            for (int i = 0; i < word.length(); i++) {
                ch = word.charAt(i);
                r = ch + r; 
            }
            return r;
        }

        public String visitIDExpr(ParseRules.IDExprContext ctx) {
            String varName = ctx.ID().getText();
            if (variables_stored.containsKey(varName)) {
                return variables_stored.get(varName);
            } 
            else {
                System.out.println("Variable is not defined");
                return null;
            }
        }
    }
    private Map<String, String> variables_stored = new HashMap<>(); // Hashmap for storing variables
    private Integer savedValue = null;
    private Scanner stdin = new Scanner(System.in);
    private StatementVisitor svisitor = new StatementVisitor();
    private ExpressionVisitor evisitor = new ExpressionVisitor();
    private Tokenizer tokenizer;

    public Interpreter() throws IOException {
        this.tokenizer = new Tokenizer(
            getClass().getResourceAsStream("tokenSpec.txt"),
            ParseRules.VOCABULARY
        );
    }

    public ParseRules.ProgramContext parse(Path sourceFile) throws IOException {
        TokenStream tokenStream = tokenizer.streamFrom(sourceFile);
        ParseRules parser = new ParseRules(tokenStream);
        Errors.register(parser);
        return parser.program();
    }

    public void execute(ParseRules.ProgramContext parseTree) {
        // to execute the whole program, we just call visit() on the  root
        // node of the parse tree!
        svisitor.visit(parseTree);
    }

    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            Errors.error("need 1 command-line arg: input source file");
        }
        Path sourceFile = Path.of(args[0]);
        Interpreter interp = new Interpreter();
        ParseRules.ProgramContext parseTree = interp.parse(sourceFile);
        interp.execute(parseTree);
    }
}
