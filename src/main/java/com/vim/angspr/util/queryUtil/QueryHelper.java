package com.vim.angspr.util.queryUtil;

public class QueryHelper {

  public static String generateSelect(Select select) {
    StringBuffer selectQuery = new StringBuffer();
    selectQuery
      .append("SELECT ").append(select.select)
      .append(" FROM ").append(select.from)
      .append(" WHERE ").append(select.where)
      .append(";");

    return selectQuery.toString();
  }

}
