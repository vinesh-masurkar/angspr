package com.vim.angspr.tools.ritdoec.firststep;

import static org.junit.Assert.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.approvaltests.Approvals;

public class CustomerTest {

  private Customer customer;
  private String expectedStatement;

  @BeforeEach
  public void setUp() {
    expectedStatement = "Rental Record for TestCustomer\n" +
      "\tHamlet\t2.0\n" +
      "\tAs You Like It\t12.0\n" +
      "\tOthello\t6.0\n" +
      "Amount owed is 20.0\n" +
      "You earned 4 frequent renter points";
    customer = new Customer("TestCustomer");
    addRentals(customer);
  }

  @Test
  public void assertStatementUnitTest() {
    assertEquals(expectedStatement, customer.statement());
  }

  @Test
  public void verifyStatementApprovalTest() {
    Approvals.verify(customer.statement());
    //assertEquals(expectedStatement, customer.statement());
  }

  private Customer addRentals(Customer customer) {
    customer.addRental(Rental.builder()
      .movie(Movie.builder()
        .title("Hamlet")
        .priceCode(0)
        .build())
      .daysRented(2)
      .build());
    customer.addRental(Rental.builder()
      .movie(Movie.builder()
        .title("As You Like It")
        .priceCode(1)
        .build())
      .daysRented(4)
      .build());
    customer.addRental(Rental.builder()
      .movie(Movie.builder()
        .title("Othello")
        .priceCode(2)
        .build())
      .daysRented(6)
      .build());
    return customer;
  }

}
