// Generated from si413/ParseRules.g4 by ANTLR 4.13.1
package si413;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ParseRules}.
 */
public interface ParseRulesListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code NonEmptyProg}
	 * labeled alternative in {@link ParseRules#program}.
	 * @param ctx the parse tree
	 */
	void enterNonEmptyProg(ParseRules.NonEmptyProgContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NonEmptyProg}
	 * labeled alternative in {@link ParseRules#program}.
	 * @param ctx the parse tree
	 */
	void exitNonEmptyProg(ParseRules.NonEmptyProgContext ctx);
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
	 * Enter a parse tree produced by {@link ParseRules#stat}.
	 * @param ctx the parse tree
	 */
	void enterStat(ParseRules.StatContext ctx);
	/**
	 * Exit a parse tree produced by {@link ParseRules#stat}.
	 * @param ctx the parse tree
	 */
	void exitStat(ParseRules.StatContext ctx);
	/**
	 * Enter a parse tree produced by {@link ParseRules#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(ParseRules.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ParseRules#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(ParseRules.ExprContext ctx);
}