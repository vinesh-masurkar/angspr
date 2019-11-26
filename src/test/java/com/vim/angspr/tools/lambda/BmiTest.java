package com.vim.angspr.tools.lambda;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BmiTest {
  private int ht, wt;
  private String expected;

  @Before
  public void setUp() throws Exception {
    ht = 5 * 12; wt = 150;
    expected = Bmi.imperativeBmi(wt, ht);
  }

  @Test
  public void imperativeBmi() {
    assertEquals(expected, Bmi.Type.OVER.type());
  }

  @Test
  public void declarativeIfElseBmi() {
    assertEquals(expected, Bmi.declarativeIfElseBmi(wt, ht));
  }

  @Test
  public void declarativeMapForBmi() {
    assertEquals(expected, Bmi.declarativeMapForBmi(wt, ht));
  }

  @Test
  public void declarativeStreamLambdaBmi() {
    assertEquals(expected, Bmi.declarativeStreamLambdaBmi(wt, ht));
  }

  @Test
  public void declarativeStreamLambdaCollectBmi() {
    assertEquals(expected, Bmi.declarativeStreamLambdaCollectBmi(wt, ht));
  }

  @Test
  public void declarativeFunctionBmi() {
    assertEquals(expected, Bmi.declarativeFunctionBmi(wt, ht));
  }

}
