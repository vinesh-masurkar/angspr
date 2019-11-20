package com.vim.angspr.tools.lambda;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FuncTest {

  @Before
  public void setUp() throws Exception {
    // DO NOTHING
  }

  @Test
  public void imperativeBmi() {
    int ht = 5*12, wt = 150;
    String actual = Func.Bmi.imperativeBmi(wt, ht);
    assertEquals(Func.Bmi.Type.OVER.type(), actual);
  }

  @Test
  public void declarativeIfElseBmi() {
    int ht = 5*12, wt = 150;
    String actual = Func.Bmi.declarativeIfElseBmi(wt, ht);
    assertEquals(Func.Bmi.imperativeBmi(wt, ht), actual);
  }

  @Test
  public void declarativeMapForBmi() {
    int ht = 5*12, wt = 150;
    String actual = Func.Bmi.declarativeMapForBmi(wt, ht);
    assertEquals(Func.Bmi.imperativeBmi(wt, ht), actual);
  }

  @Test
  public void declarativeStreamLambdaBmi() {
    int ht = 5*12, wt = 150;
    String actual = Func.Bmi.declarativeStreamLambdaBmi(wt, ht);
    assertEquals(Func.Bmi.imperativeBmi(wt, ht), actual);
  }

  @Test
  public void declarativeStreamLambdaCollectBmi() {
    int ht = 5*12, wt = 150;
    String actual = Func.Bmi.declarativeStreamLambdaCollectBmi(wt, ht);
    assertEquals(Func.Bmi.imperativeBmi(wt, ht), actual);
  }

}
