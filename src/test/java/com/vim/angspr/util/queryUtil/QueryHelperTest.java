package com.vim.angspr.util.queryUtil;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class QueryHelperTest {

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testSelect() {
      String expectedSelect = "SELECT * FROM T WHERE C1=1;";
      Select select = Select.builder()
        .select("*")
        .from("T")
        .where("C1=1")
        .build();
      String actualSelect = QueryHelper.generateSelect(select);
      assertEquals(expectedSelect, actualSelect);
    }
}
