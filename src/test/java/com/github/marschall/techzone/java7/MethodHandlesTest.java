package com.github.marschall.techzone.java7;

import static org.junit.Assert.*;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodHandles.Lookup;
import java.lang.invoke.MethodType;
import java.lang.reflect.Method;

import org.junit.Test;

public class MethodHandlesTest {

  @Test
  public void testDirectLookup() throws Throwable {
    Lookup lookup = MethodHandles.publicLookup();
    MethodType methodType = MethodType.methodType(String.class, String.class);
    MethodHandle unboundHandle = lookup.findVirtual(Messager.class, "echo", methodType);
    
    Messager messager = new Messager("hello");
    assertEquals("hello world", unboundHandle.invoke(messager, "world"));
    
    MethodHandle boundReceiver = unboundHandle.bindTo(messager);
    assertEquals("hello techzone", boundReceiver.invoke("techzone"));
    
    MethodHandle boundArgument = boundReceiver.bindTo("audience");
    assertEquals("hello audience", boundArgument.invoke());
  }
  
  @Test
  public void testUnreflect() throws Throwable {
    Method method = Messager.class.getDeclaredMethod("echo", String.class);
    MethodHandle unboundHandle = MethodHandles.publicLookup().unreflect(method);
    
    Messager messager = new Messager("hello");
    assertEquals("hello world", unboundHandle.invoke(messager, "world"));
    
    MethodHandle boundReceiver = unboundHandle.bindTo(messager);
    assertEquals("hello techzone", boundReceiver.invoke("techzone"));
    
    MethodHandle boundArgument = boundReceiver.bindTo("audience");
    assertEquals("hello audience", boundArgument.invoke());
    
  }

  public static final class Messager {

    private final String prefix;

    Messager(String prefix) {
      this.prefix = prefix;
    }

    public String echo(String postfix) {
      return prefix + ' ' + postfix;
    }

  }

}
