package com.vim.angspr.util.query;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Select {
  private String selectStr;
  private String fromStr;
  private String whereStr;

  private String [] select;
  private String [] from;
  private Where where;

  public String select() {
    return select.length > 0 ? String.join(",", select) : "";
  }

  public String from() {
    return from.length > 0 ? String.join(",", from) : "";
  }

  public String where() {
    return where.where();
  }
}
