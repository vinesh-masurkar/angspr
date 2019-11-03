package com.vim.angspr.util.query;

public abstract class Condition {

  String lhs;
  String rhs;

  String[] vals;

  Operator operator;
  boolean hasValue;

  Condition(Operator oper) {
    this.operator = oper;
    this.hasValue = true;
  }

  Condition(Operator oper, String[] vals) {
    this.vals = vals;
    this.operator = oper;
    this.hasValue = true;
  }

  Condition(Operator oper, String lhs, String rhs) {
    this.lhs = lhs;
    this.rhs = rhs;
    this.operator = oper;
    this.hasValue = true;
  }

  public String evaluate() {
    String eval = new String();
    if (hasValue) {
      switch (this.operator) {
        case AND:
        case OR:
        case NOT:
          eval = this.operator.operator();
          break;

        case EQUALS:
        case NOT_EQUALS:
        case GREATER_THAN:
        case LESS_THAN:
        case GREATER_OR_EQUAL:
        case LESS_OR_EQUAL:
        case BETWEEN:
          eval = this.lhs + this.operator.operator() + this.rhs;
          break;

        case LIKE:
        case IN:
          eval = this.operator.operator() + "( " + String.join(",", vals) +" )";
          break;

        default: break;

      }
    }
    return eval;
  }

  // ENUM OPERATOR
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
}
