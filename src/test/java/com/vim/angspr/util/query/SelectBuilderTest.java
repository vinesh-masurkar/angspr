package com.vim.angspr.util.query;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class SelectBuilderTest {

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testBuildSimpleSelect() {
      String expectedSelect = "SELECT * FROM T WHERE C1=1;";
      Select select = Select.builder()
        .selectStr("*")
        .fromStr("T")
        .whereStr("C1=1")
        .build();
      String actualSelect = SelectBuilder.buildSimpleSelect(select);
      assertEquals(expectedSelect, actualSelect);
    }

    @Test
    public void testBuildSelect() {
        String expectedSelect = "SELECT * FROM T WHERE C1=1;";
        Select select = Select.builder()
            .select(new ArrayList<>(Arrays.asList(new String [] {"*"})))
            .from(new ArrayList<>(Arrays.asList(new String [] {"T"})))
            .where("C1=1")
            .build();
        String actualSelect = SelectBuilder.buildSelect(select);
        assertEquals(expectedSelect, actualSelect);
    }
}
