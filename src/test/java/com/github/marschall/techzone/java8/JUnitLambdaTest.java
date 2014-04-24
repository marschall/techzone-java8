package com.github.marschall.techzone.java8;

import static com.github.marschall.junitlambda.LambdaAssert.assertRaises;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

public class JUnitLambdaTest {
  
  @Test
  public void testAssertRaises() {
    assertRaises(() -> aMethodThrowingException(), ArithmeticException.class);
    
    assertRaises(this::aMethodThrowingException, ArithmeticException.class);
  }
  
  @Test
  public void testAssertRaisesOld() {
    try {
      aMethodThrowingException();
      fail("should throw a " + ArithmeticException.class);
    } catch (ArithmeticException e) {
      // should reach here
      assertTrue(true);
    }
  }
    
  
  private int aMethodThrowingException() {
    return 1 / 0;
  }

}
