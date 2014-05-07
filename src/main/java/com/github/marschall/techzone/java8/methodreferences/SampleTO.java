package com.github.marschall.techzone.java8.methodreferences;

import java.math.BigDecimal;


public class SampleTO {

  public BigDecimal getAmount() {
    return new BigDecimal("24.13");
  }

  public String getCurrency() {
    return "USD";
  }

}
