package com.vim.angspr.util.query;

public class SelectBuilder {

  public static String buildSimpleSelect(Select select) {
    StringBuffer selectQuery = new StringBuffer();
    selectQuery
      .append("SELECT ").append(select.getSelectStr())
      .append(" FROM ").append(select.getFromStr())
      .append(" WHERE ").append(select.getWhereStr())
      .append(";");

    return selectQuery.toString();
  }

  public static String buildSelect(Select select) {
    StringBuffer selectQuery = new StringBuffer();
    selectQuery
      .append("SELECT ").append(String.join(",", select.getSelect()))
      .append(" FROM ").append(String.join(",", select.getFrom()))
      .append(" WHERE ").append(select.getWhere())
      .append(";");

    return selectQuery.toString();
  }

}
