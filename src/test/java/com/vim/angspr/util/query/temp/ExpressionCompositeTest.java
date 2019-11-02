package com.vim.angspr.util.query.temp;

import com.vim.angspr.util.query.temp.ExpressionComposite;
import com.vim.angspr.util.query.temp.Term;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ExpressionCompositeTest {

  private ExpressionComposite expr;

  @Before
  public void setUp() throws Exception {
    expr = new ExpressionComposite();
  }

  @Test
  public void testCompositeWithTerms() {
    String expectedExpr = "TABLE1.COLUMN2 IS EQUAL 123;";
    expr = ExpressionComposite.builder()
      .LeftOperand(Term.builder().value("TABLE1.COLUMN2").build())
      .opertor("IS EQUAL")
      .RightOperand(Term.builder().value("123").build())
      .build();
    String actualExpr = expr.evaluate();
    assertEquals(expectedExpr, actualExpr);
  }

  @Test
  public void testCompositeWithExpressions() {
    String expectedExpr = "TABLE1.COLUMN2 IS EQUAL 123;";
    expr = ExpressionComposite.builder()
      .LeftOperand(Term.builder().value("TABLE1.COLUMN2").build())
      .opertor("IS EQUAL")
      .RightOperand(Term.builder().value("123").build())
      .build();
    String actualExpr = expr.evaluate();
    assertEquals(expectedExpr, actualExpr);
  }
}
