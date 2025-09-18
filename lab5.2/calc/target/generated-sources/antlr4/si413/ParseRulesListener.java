// Generated from si413/ParseRules.g4 by ANTLR 4.13.1
package si413;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ParseRules}.
 */
public interface ParseRulesListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code ProgProg}
	 * labeled alternative in {@link ParseRules#program}.
	 * @param ctx the parse tree
	 */
	void enterProgProg(ParseRules.ProgProgContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ProgProg}
	 * labeled alternative in {@link ParseRules#program}.
	 * @param ctx the parse tree
	 */
	void exitProgProg(ParseRules.ProgProgContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EmptyProg}
	 * labeled alternative in {@link ParseRules#program}.
	 * @param ctx the parse tree
	 */
	void enterEmptyProg(ParseRules.EmptyProgContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EmptyProg}
	 * labeled alternative in {@link ParseRules#program}.
	 * @param ctx the parse tree
	 */
	void exitEmptyProg(ParseRules.EmptyProgContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PrintStat}
	 * labeled alternative in {@link ParseRules#stat}.
	 * @param ctx the parse tree
	 */
	void enterPrintStat(ParseRules.PrintStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PrintStat}
	 * labeled alternative in {@link ParseRules#stat}.
	 * @param ctx the parse tree
	 */
	void exitPrintStat(ParseRules.PrintStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IDStat}
	 * labeled alternative in {@link ParseRules#stat}.
	 * @param ctx the parse tree
	 */
	void enterIDStat(ParseRules.IDStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IDStat}
	 * labeled alternative in {@link ParseRules#stat}.
	 * @param ctx the parse tree
	 */
	void exitIDStat(ParseRules.IDStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RevExpr}
	 * labeled alternative in {@link ParseRules#expr}.
	 * @param ctx the parse tree
	 */
	void enterRevExpr(ParseRules.RevExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RevExpr}
	 * labeled alternative in {@link ParseRules#expr}.
	 * @param ctx the parse tree
	 */
	void exitRevExpr(ParseRules.RevExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BoolExpr}
	 * labeled alternative in {@link ParseRules#expr}.
	 * @param ctx the parse tree
	 */
	void enterBoolExpr(ParseRules.BoolExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BoolExpr}
	 * labeled alternative in {@link ParseRules#expr}.
	 * @param ctx the parse tree
	 */
	void exitBoolExpr(ParseRules.BoolExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IDExpr}
	 * labeled alternative in {@link ParseRules#expr}.
	 * @param ctx the parse tree
	 */
	void enterIDExpr(ParseRules.IDExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IDExpr}
	 * labeled alternative in {@link ParseRules#expr}.
	 * @param ctx the parse tree
	 */
	void exitIDExpr(ParseRules.IDExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LitExpr}
	 * labeled alternative in {@link ParseRules#expr}.
	 * @param ctx the parse tree
	 */
	void enterLitExpr(ParseRules.LitExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LitExpr}
	 * labeled alternative in {@link ParseRules#expr}.
	 * @param ctx the parse tree
	 */
	void exitLitExpr(ParseRules.LitExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code InputExpr}
	 * labeled alternative in {@link ParseRules#expr}.
	 * @param ctx the parse tree
	 */
	void enterInputExpr(ParseRules.InputExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code InputExpr}
	 * labeled alternative in {@link ParseRules#expr}.
	 * @param ctx the parse tree
	 */
	void exitInputExpr(ParseRules.InputExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprExpr}
	 * labeled alternative in {@link ParseRules#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprExpr(ParseRules.ExprExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprExpr}
	 * labeled alternative in {@link ParseRules#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprExpr(ParseRules.ExprExprContext ctx);
}