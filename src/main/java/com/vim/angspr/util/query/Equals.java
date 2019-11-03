package com.vim.angspr.util.query;

public class Equals extends Condition {

  public Equals(String lhs, String rhs) {
    super(Operator.EQUALS, lhs, rhs);
  }
}
