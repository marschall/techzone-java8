package com.github.marschall.techzone.java8.defaultmethods;

import java.math.BigDecimal;

public class TransactionTO {

  public Long getId() {
    return 42L;
  }
  
  public BigDecimal getAmount() {
    return BigDecimal.TEN;
  }

}
