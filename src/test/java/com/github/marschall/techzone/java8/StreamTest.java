package com.github.marschall.techzone.java8;

import static org.junit.Assert.assertEquals;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.Test;

import com.github.marschall.techzone.java8.StreamTest.Person.Sex;

public class StreamTest {

  @Test
  public void primeStream() {
    // 2, 3, 5, 7, 11, 13
    BigInteger sixthPrime = Stream.iterate(BigInteger.valueOf(2L), (i) -> i.nextProbablePrime())
      .skip(5)
      .findFirst().get();
    assertEquals(13, sixthPrime.intValue());
    
    int sixthPrimeInt = IntStream.rangeClosed(0, Integer.MAX_VALUE)
      .filter((i) -> BigInteger.valueOf(i).isProbablePrime(10))
      .skip(5)
      .findFirst().getAsInt();
    assertEquals(13, sixthPrimeInt);
  }
  
  @Test
  public void lazyOperations() {
    int value = IntStream.rangeClosed(1, Integer.MAX_VALUE)
      .map((i) -> i + 1)
      .map((i) -> i + 1)
      .map((i) -> i + 1)
      .skip(999999)
      .filter((i) -> (i % 2) == 0)
      .findFirst().getAsInt();
    assertEquals(1000004, value);
  }
  
  @Test
  public void streamOnCollection() {
    List<Person> roster = new ArrayList<>();
    roster.add(new Person());
    // TODO add persons
    double average = roster
        .stream()
//        .parallelStream()
        .filter(p -> p.getGender() == Person.Sex.MALE)
        .mapToInt(Person::getAge)
        .average()
        .getAsDouble();
    
    List<Sex> sexes = roster
        .stream()
        .filter(p -> p.getAge() == 42)
        .map(Person::getGender)
        .collect(Collectors.toList());
  }
  
  static final class Person {
    
    enum Sex {
      MALE,
      FEMALE,
      YES_PLEASE;
    }
    
    int getAge() {
      return 42;
    }
    
    Sex getGender() {
      return Sex.MALE;
    }
    
  }

}
