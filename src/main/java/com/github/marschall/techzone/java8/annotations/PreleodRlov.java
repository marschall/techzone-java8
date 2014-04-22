package com.github.marschall.techzone.java8.annotations;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.SOURCE;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(SOURCE)
@Target(TYPE)
@Repeatable(PreloadRlovs.class)
public @interface PreleodRlov {
  
  String parameterName();
  String parameterValue();

}
