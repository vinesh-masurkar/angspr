package com.vim.angspr.util.query.temp;

import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExpressionComposite implements Expression {
  private Expression LeftOperand;
  private String opertor;
  private Expression RightOperand;
  // addExpresssion(Expression expr);
  // removeExpression(Expression expr);

  @Override
  public String evaluate() {
    return new StringBuffer()
      .append(getLeftOperand().evaluate())
      .append(" " + getOpertor() + " ")
      .append(getRightOperand().evaluate())
      .append(";")
      .toString();
  }
}
