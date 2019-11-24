package com.vim.angspr.tools.lambda;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BmiTest {
  private int ht, wt;
  private String actual;

  @Before
  public void setUp() throws Exception {
    ht = 5 * 12; wt = 150;
    actual = Bmi.imperativeBmi(wt, ht);
  }

  @Test
  public void imperativeBmi() {
    assertEquals(Bmi.Type.OVER.type(), actual);
  }

  @Test
  public void declarativeIfElseBmi() {
    assertEquals(Bmi.imperativeBmi(wt, ht), actual);
  }

  @Test
  public void declarativeMapForBmi() {
    assertEquals(Bmi.imperativeBmi(wt, ht), actual);
  }

  @Test
  public void declarativeStreamLambdaBmi() {
    assertEquals(Bmi.imperativeBmi(wt, ht), actual);
  }

  @Test
  public void declarativeStreamLambdaCollectBmi() {
    assertEquals(Bmi.imperativeBmi(wt, ht), actual);
  }

}
