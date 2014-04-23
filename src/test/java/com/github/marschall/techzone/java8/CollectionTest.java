package com.github.marschall.techzone.java8;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.junit.Test;

public class CollectionTest {
  
  
  // forEach
  
  @Test
  public void collectionRemoveIf() {
    Collection<String> databases = new ArrayList<>(Arrays.asList("DB2", "Derby", "H2", "HSQL"));
    databases.removeIf((s) -> s.charAt(0) == 'H');
    
    assertEquals(Arrays.asList("DB2", "Derby"), databases);
  }
  
  @Test
  public void mapMethods() {
    Map<Integer, String> numberNames = new HashMap<>();
    numberNames.put(1, "one");
    numberNames.put(2, "two");
    numberNames.put(3, "three");
    numberNames.put(4, "four");
    numberNames.put(5, "five");
    numberNames.put(6, "six");
    numberNames.put(7, "seven");
    numberNames.put(8, "eight");
    numberNames.put(9, "nine");
    
    // getOrDefault
    assertEquals("Unknown", numberNames.getOrDefault(10, "Unknown"));
    
    // putIfAbsent
    numberNames.putIfAbsent(9, "niner");
    assertEquals("nine", numberNames.get(9));
    numberNames.putIfAbsent(10, "ten");
    assertEquals("ten", numberNames.get(10));

    // remove
    numberNames.remove(10, "teen");
    assertEquals("ten", numberNames.get(10));
    numberNames.remove(10, "ten");
    assertNull(numberNames.get(10));
    
    // replace
    assertNull(numberNames.get(11));
    numberNames.replace(11, "elven");
    assertNull(numberNames.get(11));
    numberNames.put(11, "elven");
    assertEquals("elven", numberNames.get(11));
    numberNames.replace(11, "elf");
    assertEquals("elf", numberNames.get(11));
    numberNames.replace(11, "elven", "eleven");
    assertEquals("elf", numberNames.get(11));
    numberNames.replace(11, "elf", "eleven");
    assertEquals("eleven", numberNames.get(11));
  }

  
  @Test
  public void mapCompute() {
    Map<Integer, String> numberNames = new HashMap<>();
    numberNames.put(1, "one");
    numberNames.put(2, "two");
    numberNames.put(3, "three");
    numberNames.put(4, "four");
    numberNames.put(5, "five");
    numberNames.put(6, "six");
    numberNames.put(7, "seven");
    numberNames.put(8, "eight");
    numberNames.put(9, "nine");
    
    // computeIfAbsent
    String value = numberNames.computeIfAbsent(10, (i) -> i.toString());
    assertEquals("10", value);
    assertEquals("10", numberNames.get(10));
    
    // compute
    assertEquals("nine", numberNames.get(9));
    numberNames.compute(9, (i, s) -> null);
    assertFalse(numberNames.containsKey(9));
    
    assertEquals("eight", numberNames.get(8));
    numberNames.compute(8, (i, s) -> s.toUpperCase(Locale.US));
    assertEquals("EIGHT", numberNames.get(8));
    numberNames.compute(10, (i, s) -> "ten");
    assertEquals("ten", numberNames.get(10));
    

    // computeIfPresent
    assertEquals("seven", numberNames.get(7));
    numberNames.computeIfPresent(7, (i, s) -> s.toUpperCase(Locale.US));
    assertEquals("SEVEN", numberNames.get(7));
    numberNames.computeIfPresent(11, (i, s) -> "new");
    assertFalse(numberNames.containsKey(11));
  }
  
  @Test
  public void computeIfAbsent() {
    Map<String, List<Integer>> map = new HashMap<>();
    List<Integer> list = map.computeIfAbsent("key", (s) -> new ArrayList<>());
    list.add(1);
    
  }

}
