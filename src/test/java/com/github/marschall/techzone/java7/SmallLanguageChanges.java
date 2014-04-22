package com.github.marschall.techzone.java7;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SmallLanguageChanges {

  @Test
  public void underscoreLiterals() {
    assertEquals(1000000, 1_000_000);
    assertEquals(1000, 1_0_0_0);
  }

}
