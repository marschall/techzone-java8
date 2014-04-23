package com.github.marschall.techzone.java7;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Test;

public class DefaultFileSystemTest {
  
  @Test
  public void copy() throws IOException {
    Path source = Paths.get("src/test/resources/data.sql");
    source = Paths.get("src").resolve("test").resolve("resources").resolve("data.sql");
    source = Paths.get("src", "test", "resources", "data.sql");
    
    Path target = Paths.get("target", "demo", "file.sql");
    Files.createDirectories(target.getParent());
    try {
      Files.copy(source, target);
    } finally {
      Files.deleteIfExists(target);
      Files.deleteIfExists(target.getParent());
    }
    
  }

}
