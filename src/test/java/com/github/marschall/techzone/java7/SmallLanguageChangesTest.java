package com.github.marschall.techzone.java7;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class SmallLanguageChangesTest {
  
  @Test
  public void diamondOperator() {
    Map<String, List<Integer>> map = new HashMap<>();
    assertEquals(0, map.size());
  }
  
  @Test
  public void tryWithResources() throws IOException {
    try (InputStream stream = Files.newInputStream(Paths.get("pom.xml"))) {
      
    }
  }

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
