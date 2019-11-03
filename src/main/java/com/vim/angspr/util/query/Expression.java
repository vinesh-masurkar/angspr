package com.vim.angspr.util.query;

public class Expression {

  // NULL("IS NULL") : <String>
  public static class Null extends Condition {
    public Null() {
      super(Operator.NULL);
    }
  }

  // NOT_NULL("IS NOT NULL") : <String>
  public static class NotNull extends Condition {
    public NotNull() {
      super(Operator.NOT_NULL);
    }
  }

  // AND ("AND") : <String>
  public static class And extends Condition {
    public And() {
      super(Operator.AND);
    }
  }

  // OR ("OR") : <String>
  public static class Or extends Condition {
    public Or() {
      super(Operator.OR);
    }
  }

  // NOT ("NOT") : <String>
  public static class Not extends Condition {
    public Not() {
      super(Operator.NOT);
    }
  }

  // EQUALS ("=") : <String, String>
  public static class Equals extends Condition {
    public Equals(String lhs, String rhs) {
      super(Operator.EQUALS, lhs, rhs);
    }
  }

  // NOT_EQUALS ("<>") : <String, String>
  public static class NotEquals extends Condition {
    public NotEquals(String lhs, String rhs) {
      super(Operator.NOT_EQUALS, lhs, rhs);
    }
  }

  // GREATER_THAN ("<") : <String, String>
  public static class GreaterThan extends Condition {
    public GreaterThan(String lhs, String rhs) {
      super(Operator.GREATER_THAN, lhs, rhs);
    }
  }

  // LESS_THAN (">") : <String, String>
  public static class LessThan extends Condition {
    public LessThan(String lhs, String rhs) {
      super(Operator.LESS_THAN, lhs, rhs);
    }
  }

  // GREATER_OR_EQUAL (">=") : <String, String>
  public static class GreaterOrEqual extends Condition {
    public GreaterOrEqual(String lhs, String rhs) {
      super(Operator.GREATER_OR_EQUAL, lhs, rhs);
    }
  }

  // LESS_OR_EQUAL ("<=") : <String, String>
  public static class LessOrEqual extends Condition {
    public LessOrEqual(String lhs, String rhs) {
      super(Operator.LESS_OR_EQUAL, lhs, rhs);
    }
  }

  // BETWEEN ("BETWEEN") : <String, String>
  public static class Between extends Condition {
    public Between(String lhs, String rhs) {
      super(Operator.BETWEEN, lhs, rhs);
    }
  }

  // LIKE ("LIKE") : <String[]>
  public static class Like extends Condition {
    public Like(String[] vals) {
      super(Operator.LIKE, vals);
    }
  }

  // IN ("IN"): <String[]>
  public static class In extends Condition {
    public In(String[] vals) {
      super(Operator.IN, vals);
    }
  }

}
