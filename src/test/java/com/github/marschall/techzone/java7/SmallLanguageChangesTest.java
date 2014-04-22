package com.github.marschall.techzone.java7;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SmallLanguageChangesTest {

  @Test
  public void underscoreLiterals() {
    assertEquals(1000000, 1_000_000);
    assertEquals(1000, 1_0_0_0);
  }

  @Test
  public void binaryLiterals() {
    assertEquals((1 << 2) | (0x01), 0b101);
  }
  
  @Test
  public void stringSwitch() {
    String s = "two";
    int i;
    switch (s) {
      case "one":
        i = 1;
        break;
      case "two":
        i = 2;
        break;
      case "three":
        i = 3;
        break;
      default:
        i = 0;
    }
    assertEquals(2, i);
  }

}
