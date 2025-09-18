// Generated from si413/ParseRules.g4 by ANTLR 4.13.1
package si413;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ParseRules}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ParseRulesVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code ProgProg}
	 * labeled alternative in {@link ParseRules#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgProg(ParseRules.ProgProgContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EmptyProg}
	 * labeled alternative in {@link ParseRules#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmptyProg(ParseRules.EmptyProgContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PrintStat}
	 * labeled alternative in {@link ParseRules#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintStat(ParseRules.PrintStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IDStat}
	 * labeled alternative in {@link ParseRules#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIDStat(ParseRules.IDStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code RevExpr}
	 * labeled alternative in {@link ParseRules#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRevExpr(ParseRules.RevExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BoolExpr}
	 * labeled alternative in {@link ParseRules#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolExpr(ParseRules.BoolExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IDExpr}
	 * labeled alternative in {@link ParseRules#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIDExpr(ParseRules.IDExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LitExpr}
	 * labeled alternative in {@link ParseRules#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLitExpr(ParseRules.LitExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code InputExpr}
	 * labeled alternative in {@link ParseRules#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInputExpr(ParseRules.InputExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprExpr}
	 * labeled alternative in {@link ParseRules#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprExpr(ParseRules.ExprExprContext ctx);
}