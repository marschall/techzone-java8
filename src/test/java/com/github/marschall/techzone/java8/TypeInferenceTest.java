package com.github.marschall.techzone.java8;

import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class TypeInferenceTest {

  @Test
  public void processStringList() {
    processStringList(Collections.emptyList());
    processStringList(Collections.<String>emptyList());
  }
  void processStringList(List<String> stringList) {
    // process stringList
  }

}
