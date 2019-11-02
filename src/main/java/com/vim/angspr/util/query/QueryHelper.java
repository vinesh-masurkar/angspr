package com.vim.angspr.util.query;

public class QueryHelper {

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
      .append(" WHERE ").append(select.getWhereStr())
      .append(";");

    return selectQuery.toString();
  }

  public static String buildSelectWithWhere(Select select) {
    StringBuffer selectQuery = new StringBuffer();
    selectQuery
      .append("SELECT ").append(select.select())
      .append(" FROM ").append(select.from())
      .append(" WHERE ").append(select.where())
      .append(";");

    return selectQuery.toString();
  }

}
