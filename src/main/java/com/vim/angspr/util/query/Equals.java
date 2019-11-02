package com.vim.angspr.util.query;

public class Equals extends TwoOperandExpression {

  public Equals(String lhs, String rhs) {
    super(Expression.Operator.EQUALS, lhs, rhs);
  }
}
