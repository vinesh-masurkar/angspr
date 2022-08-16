package com.vim.angspr.tools.pojo;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class SimpleTest {

  private Simple s;

  @Before
  public void setUp() throws Exception {
    s = Simple.builder()
              .no(987)
              .num(12345L)
              .coll(Arrays.asList(new String("ABCD").split("")))
              .name("     New Name         ")
              .address("    522 Mulberry Lane, MI 46359       ")
              .build();
  }

  @Test
  public void testSimpleTrim() {
    try {
      Simple actual = (Simple) s.trim();
      assertEquals(new Long(12345), actual.getNum());
      assertEquals("New Name", actual.getName());
      assertEquals("522 Mulberry Lane, MI 46359", actual.getAddress());
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
