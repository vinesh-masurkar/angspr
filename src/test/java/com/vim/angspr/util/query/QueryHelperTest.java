package com.vim.angspr.util.query;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class QueryHelperTest {

    @Before
    public void setUp() throws Exception {
      // DO NOTHING
    }

    @Test
    public void testBuildSimpleSelect() {
      String expectedSelect = "SELECT * FROM T WHERE C1=1;";
      Select select = Select.builder()
        .selectStr("*")
        .fromStr("T")
        .whereStr("C1=1")
        .build();
      String actualSelect = QueryHelper.buildSimpleSelect(select);
      assertEquals(expectedSelect, actualSelect);
    }

    @Test
    public void testBuildSelect() {
        String expectedSelect = "SELECT * FROM T WHERE C1=1;";
        Select select = Select.builder()
            .select(new String [] {"*"})
            .from(new String [] {"T"})
            .whereStr("C1=1")
            .build();
        String actualSelect = QueryHelper.buildSelect(select);
        assertEquals(expectedSelect, actualSelect);
    }

  @Test
  public void testBuildSelectWithWhere() {
    String expectedSelect = "SELECT A, B FROM T1, T2 WHERE (C1 = 1);";
    Select select = Select.builder()
      .select(new String [] {"A, B"})
      .from(new String [] {"T1, T2"})
      .where(new Where.builder()
        .equals(new Expression.Equals("C1", "1"))
        .build())
      .build();
    String actualSelect = QueryHelper.buildSelectWithWhere(select);
    assertEquals(expectedSelect, actualSelect);
  }

  @Test
  public void testBuildSelectWithWhereConditions() {
    String expectedSelect = "SELECT A, B FROM T1, T2 WHERE ( (C1 = 1) AND (C2 > 3) );";
    Select select = Select.builder()
      .select(new String [] {"A, B"})
      .from(new String [] {"T1, T2"})
      .where(new Where.builder()
        .conditions(new Condition[] {
          new Expression.Equals("C1", "1"),
          new Expression.And(),
          new Expression.LessThan("C2", "3")
        })
        .build())
      .build();
    String actualSelect = QueryHelper.buildSelectWithWhere(select);
    assertEquals(expectedSelect, actualSelect);
  }

}
