package com.github.marschall.techzone.java8.defaultmethods.demo;

import java.lang.invoke.MethodHandles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@FunctionalInterface
public interface Singed {
  
  static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
  
  boolean isPositive();
  
  default boolean isNegative() {
    LOGGER.trace("default isNegative() called");
    return !isPositive();
  }
  
  public static void main(String[] args) {
    System.out.println("hello");
  }

}
