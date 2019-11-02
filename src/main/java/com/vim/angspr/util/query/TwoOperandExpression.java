package com.vim.angspr.util.query;

public abstract class TwoOperandExpression {
  String lhs;
  String rhs;
  Expression.Operator operator;
  boolean hasValue;

  TwoOperandExpression(Expression.Operator oper, String lhs, String rhs) {
    this.lhs = lhs;
    this.rhs = rhs;
    this.operator = oper;
    this.hasValue = true;
  }

  public String evaluate() {
    return (hasValue) ? this.lhs + this.operator.operator() + this.rhs : "";
  }

}
