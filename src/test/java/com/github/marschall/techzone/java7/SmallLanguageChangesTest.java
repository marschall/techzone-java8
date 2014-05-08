package com.github.marschall.techzone.java7;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

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
    try (InputStream stream = Files.newInputStream(Paths.get("pom.xml"));
        Reader reader = new InputStreamReader(stream, StandardCharsets.US_ASCII)) {
      
    }
    
    try (NonThrowingAutoCloseable closeable = new SimpleNonThrowingAutoCloseable()) {
      System.out.println("body");
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
  
  @Test
  public void objects() {
    assertTrue(Objects.equals("a", new String("a")));
    assertFalse(Objects.equals("a", null));
    assertEquals(1, Objects.hashCode(Integer.valueOf(1)));
    assertEquals(0, Objects.hashCode(null));
  }
  
  @Test
  public void autoCloseable() {
    
  }
  
  static interface NonThrowingAutoCloseable extends AutoCloseable {
    
    @Override
    public void close();
    
  }
  
  static class SimpleNonThrowingAutoCloseable implements NonThrowingAutoCloseable {
    
    SimpleNonThrowingAutoCloseable() {
      System.out.println("<init>");
    }
    
    
    @Override
    public void close() {
      System.out.println("close");
    }
    
  }

}
