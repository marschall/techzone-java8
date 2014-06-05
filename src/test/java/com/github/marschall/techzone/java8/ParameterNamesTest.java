package com.github.marschall.techzone.java8;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

import org.junit.Test;

import com.github.marschall.techzone.java8.methodreferences.MethodRefernceUser;
import com.github.marschall.techzone.java8.methodreferences.ObjectAccessor;

public class ParameterNamesTest {
  
  @Test
  public void interfaceParameterNames() throws ReflectiveOperationException {
    Method method = ObjectAccessor.class.getDeclaredMethod("getValue", Object.class);
    Parameter[] parameters = method.getParameters();
    assertEquals(1, parameters.length);
    assertEquals("arg0", parameters[0].getName());
  }
  
  @Test
  public void classParameterNames() throws ReflectiveOperationException {
    Method method = MethodRefernceUser.class.getDeclaredMethod("main", String[].class);
    Parameter[] parameters = method.getParameters();
    assertEquals(1, parameters.length);
    assertEquals("args", parameters[0].getName());
  }

}
