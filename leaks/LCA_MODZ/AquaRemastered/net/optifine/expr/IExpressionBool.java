package net.optifine.expr;

public interface IExpressionBool extends IExpression {
   boolean eval();

   @Override
   default ExpressionType getExpressionType() {
      return ExpressionType.BOOL;
   }
}
