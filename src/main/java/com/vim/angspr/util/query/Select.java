package com.vim.angspr.util.query;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class Select {
  private String selectStr;
  private String fromStr;
  private String whereStr;

  private List<String> select;
  private List<String> from;
  private String where;

  public enum Predicate {
    EQUALS ("="),
    GREATER_THAN ("<"),
    LESS_THAN (">"),
    GREATER_OR_EQUAL (">="),
    LESS_OR_EQUAL ("<="),
    NOT_EQUALS ("<>"),
    BETWEEN ("BETWEEN"),
    LIKE ("LIKE"),
    IN ("IN"),
    NULL("IS NULL"),
    NOT_NULL("IS NOT NULL");

    private final String predicate;

    Predicate(String pred) {
      this.predicate = pred;
    }
  }

  public class Where {
    String LeftOperand;
    Predicate predicate;
    List<String> RightOperand;
  }

}
