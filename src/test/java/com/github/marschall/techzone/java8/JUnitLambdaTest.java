package com.github.marschall.techzone.java8;

import static com.github.marschall.junitlambda.LambdaAssert.assertRaises;

import org.junit.Test;

public class JUnitLambdaTest {
  
  @Test
  public void testAssertRaises() {
    assertRaises(() -> aMethodThrowingException(), ArithmeticException.class);
    
    assertRaises(this::aMethodThrowingException, ArithmeticException.class);
  }
  
  private void aMethodThrowingException() {
    int i = 1 / 0;
  }

}
