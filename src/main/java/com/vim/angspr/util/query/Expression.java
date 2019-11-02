package com.vim.angspr.util.query;

public class Expression {

// LIKE ("LIKE")            <String[]>
// IN ("IN")                <String[]>
// NULL("IS NULL")          <String>
// NOT_NULL("IS NOT NULL")  <String>
// AND                      <String>
// OR                       <String>
// NOT                      <String>

  public enum Operator {

    EQUALS(" = "),
    GREATER_THAN(" < "),
    LESS_THAN(" > "),
    GREATER_OR_EQUAL(" >= "),
    LESS_OR_EQUAL(" <= "),
    NOT_EQUALS(" <> "),
    BETWEEN(" BETWEEN "),
    LIKE(" LIKE "),
    IN(" IN "),
    NULL(" IS NULL "),
    NOT_NULL(" IS NOT NULL "),
    AND(" AND "),
    OR(" OR "),
    NOT(" NOT ");

    private final String operator;

    Operator(String oper) {
      this.operator = oper;
    }

    public String operator() {
      return this.operator;
    }
  }

  // EQUALS ("=") : <String, String>
  public static class Equals extends TwoOperandExpression {
    public Equals(String lhs, String rhs) {
      super(Operator.EQUALS, lhs, rhs);
    }
  }

  // NOT_EQUALS ("<>") : <String, String>
  public static class NotEquals extends TwoOperandExpression {
    public NotEquals(String lhs, String rhs) {
      super(Operator.NOT_EQUALS, lhs, rhs);
    }
  }

  // GREATER_THAN ("<") : <String, String>
  public static class GreaterThan extends TwoOperandExpression {
    public GreaterThan(String lhs, String rhs) {
      super(Operator.GREATER_THAN, lhs, rhs);
    }
  }

  // LESS_THAN (">") : <String, String>
  public static class LessThan extends TwoOperandExpression {
    public LessThan(String lhs, String rhs) {
      super(Operator.LESS_THAN, lhs, rhs);
    }
  }

  // GREATER_OR_EQUAL (">=") : <String, String>
  public static class GreaterOrEqual extends TwoOperandExpression {
    public GreaterOrEqual(String lhs, String rhs) {
      super(Operator.GREATER_OR_EQUAL, lhs, rhs);
    }
  }

  // LESS_OR_EQUAL ("<=") : <String, String>
  public static class LessOrEqual extends TwoOperandExpression {
    public LessOrEqual(String lhs, String rhs) {
      super(Operator.LESS_OR_EQUAL, lhs, rhs);
    }
  }

  // BETWEEN ("BETWEEN") : <String, String>
  public static class Between extends TwoOperandExpression {
    public Between(String lhs, String rhs) {
      super(Operator.BETWEEN, lhs, rhs);
    }
  }

//  // AND ("AND") : <String>
//  public static class Between extends TwoOperandExpression {
//    public Between(String lhs, String rhs) {
//      super(Operator.BETWEEN, lhs, rhs);
//    }
//  }

}
