package net.optifine.shaders.config;

import net.optifine.expr.ExpressionType;
import net.optifine.expr.IExpressionBool;

public class ExpressionShaderOptionSwitch implements IExpressionBool {
   private ShaderOptionSwitch shaderOption;

   public ExpressionShaderOptionSwitch(ShaderOptionSwitch shaderOption) {
      this.shaderOption = shaderOption;
   }

   @Override
   public boolean eval() {
      return ShaderOptionSwitch.isTrue(this.shaderOption.getValue());
   }

   @Override
   public ExpressionType getExpressionType() {
      return ExpressionType.BOOL;
   }

   @Override
   public String toString() {
      return "" + this.shaderOption;
   }
}
