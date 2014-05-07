package com.github.marschall.techzone.java8.methodreferences;


public class MethodRefernceUser {

  public static void main(String[] args) {
    PojoLogger logger = new PojoLogger();

    logger.logProperty(SampleTO::getAmount);
    logger.logProperty(SampleTO::getCurrency);

  }

}
