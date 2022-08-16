package com.vim.angspr.tools.salestax;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

class SalesTaxTest {

  @Test
  public void testSalesTaxCalculation() {
    Item item = new Item();
    Double tax = SalesTax.calculate(item);
  }

}
