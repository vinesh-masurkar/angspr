package com.vim.angspr.tools.ritdoec.firststep;

import lombok.Getter;
import lombok.Setter;

import java.util.Enumeration;
import java.util.Vector;

@Getter
@Setter
class Customer {
  private String name;
  private Vector rentals = new Vector();

  public Customer(String name) {
    this.name = name;
  }

  public void addRental(Rental arg) {
    rentals.addElement(arg);
  }

  public String getName() {
    return name;
  }

  public String statement() {
    Enumeration rentalEnum = rentals.elements();
    String result = "Rental Record for " + getName() + "\n";
    while (rentalEnum.hasMoreElements()) {
      Rental each = (Rental) rentalEnum.nextElement();
      //show figures for this rental
      result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(each.getCharge()) + "\n";
    }
    //add footer lines
    result += "Amount owed is " + String.valueOf(getTotalAmount()) + "\n";
    result += "You earned " + String.valueOf(getTotalFrequentRenterPoints()) + " frequent renter points";
    return result;
  }

  private int getTotalFrequentRenterPoints() {
    int result = 0;
    Enumeration rentalEnum = rentals.elements();
    while (rentalEnum.hasMoreElements()) {
      Rental each = (Rental) rentalEnum.nextElement();
      result += each.getFrequentRenterPoints();
    }
    return result;
  }

  private double getTotalAmount() {
    double result = 0;
    Enumeration rentalEnum = rentals.elements();
    while (rentalEnum.hasMoreElements()) {
      Rental each = (Rental) rentalEnum.nextElement();
      result += each.getCharge();
    }
    return result;
  }

}
