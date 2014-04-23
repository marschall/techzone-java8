package com.github.marschall.techzone.java8.defaultmethods.multipleinheritance;

public class VisaTransactionTO implements TransactionTODelegate {

  private TransactionTO transactionTo;

  @Override
  public TransactionTO getTransactionTo() {
    return this.transactionTo;
  }

}
