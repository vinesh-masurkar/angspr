package com.vim.angspr.util.query;

public class Equals extends Condition {

  private Equals(String lhs, String rhs) {
    super(Operator.EQUALS, lhs, rhs);
  }

  public static Condition condition(String lhs, String rhs) {
    return new Equals(lhs, rhs);
  }

}
