package com.github.marschall.techzone.java8.methodreferences;


public interface ObjectAccessor<O, V> {

  V getValue(O o);

}
