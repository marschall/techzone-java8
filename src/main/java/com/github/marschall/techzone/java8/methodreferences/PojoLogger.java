package com.github.marschall.techzone.java8.methodreferences;


public class PojoLogger {

  private final SampleTO pojo;

  public PojoLogger() {
    this.pojo = new SampleTO();
  }

  public void logProperty(ObjectAccessor<? super SampleTO, ?> accessor) {
    System.out.println("value: " + accessor.getValue(this.pojo));
  }

}
