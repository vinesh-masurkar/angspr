package com.vim.angspr.tools.ritdoec.firststep;

import java.util.Arrays;
import static org.junit.Assert.*;

import org.approvaltests.combinations.CombinationApprovals;
import org.junit.jupiter.api.Test;

import org.approvaltests.Approvals;

public class CustomerTest {

  private Customer expectedCustomer;
  private String expectedStatement;

  @Test
  public void assertStatementUnitTest() {
    setUpExpected();
    assertEquals(expectedStatement, expectedCustomer.statement());
  }

  @Test
  public void verifyStatementApprovalTest() {
    setUpExpected();
    Approvals.verify(expectedCustomer.statement());
  }

  @Test
  public void verifyAllStatementApprovalTest() {
    Approvals.verifyAll("", Arrays.asList(
      buildTestCustomer(1, "Hamlet", 0, 2).statement(),
      buildTestCustomer(2, "As You Like It", 1, 4).statement(),
      buildTestCustomer(3, "Othello", 2, 6).statement()
    ));
  }

  @Test
  public void verifyAllCombinationsStatementApprovalTest() {
    CombinationApprovals.verifyAllCombinations(this::doTest,
      new String [] {"Hamlet", "As You Like It", "Othello"},
      new Integer[] {0, 1, 2},
      new Integer[] {2, 4, 6}
    );
  }

  @Test
  public void verifySomeCombinationsStatementApprovalTest() {
    CombinationApprovals.verifyAllCombinations(this::doTest,
      new String [] {"Hamlet", "As You Like It", "Othello"},
      new Integer[] {0, 1},
      new Integer[] {2}
    );
  }


  private String doTest(final String title, final int priceCode, final int daysRented) {
    Customer testCustomer = buildTestCustomer(1, title, priceCode, daysRented);
    return testCustomer.statement();
  }

  private void setUpExpected() {
    expectedStatement = "Rental Record for TestCustomer\n" +
      "\tHamlet\t2.0\n" +
      "\tAs You Like It\t12.0\n" +
      "\tOthello\t6.0\n" +
      "Amount owed is 20.0\n" +
      "You earned 4 frequent renter points";
    expectedCustomer = new Customer("TestCustomer");
    addRentals(expectedCustomer);
  }

  private Customer buildTestCustomer(int id, String title, int priceCode, int daysRented) {
    Customer testCustomer = new Customer("customer"+ id);
    testCustomer.addRental(Rental.builder()
      .movie(Movie.builder()
        .title(title)
        .priceCode(priceCode)
        .build())
      .daysRented(daysRented)
      .build());
    return testCustomer;
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
