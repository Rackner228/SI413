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
	 * Visit a parse tree produced by the {@code NonEmptyProg}
	 * labeled alternative in {@link ParseRules#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNonEmptyProg(ParseRules.NonEmptyProgContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EmptyProg}
	 * labeled alternative in {@link ParseRules#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmptyProg(ParseRules.EmptyProgContext ctx);
	/**
	 * Visit a parse tree produced by {@link ParseRules#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStat(ParseRules.StatContext ctx);
	/**
	 * Visit a parse tree produced by {@link ParseRules#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(ParseRules.ExprContext ctx);
}