package com.github.marschall.techzone.java8.defaultmethods.multipleinheritance;

import java.math.BigDecimal;

public interface TransactionTODelegate {
  
  TransactionTO getTransactionTo();
  
  default Long getId() {
    return getTransactionTo().getId();
  }
  
  default BigDecimal getAmount() {
    return getTransactionTo().getAmount();
  }

}
