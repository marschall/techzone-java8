package com.github.marschall.techzone.java7;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.time.Instant;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class DefaultFileSystemTest {
  
  @Test
  public void copy() throws IOException {
    Path source = Paths.get("src/test/resources/data.sql");
    source = Paths.get("src").resolve("test").resolve("resources").resolve("data.sql");
    source = Paths.get("src", "test", "resources", "data.sql");

    Path target = Paths.get("target", "demo", "file.sql");
    assertTrue(Files.exists(source));
    assertFalse(Files.exists(target));
    Files.createDirectories(target.getParent());
    try {
      Files.copy(source, target);
    } finally {
      Files.deleteIfExists(target);
      Files.deleteIfExists(target.getParent());
    }
    
  }
  
  @Test
  public void conversion() {
    File file = Paths.get("src/test/resources/data.sql").toFile();
    Path path = new File("src/test/resources/data.sql").toPath();
  }
  
  @Test
  public void directoryStream() throws IOException {
    Path folder = Paths.get("src", "test", "java", "com", "github", "marschall", "techzone", "java8");
    List<Path> tests = new ArrayList<>(3);
    try (DirectoryStream<Path> stream = Files.newDirectoryStream(folder, "*Test.java")) {
      for (Path test : stream) {
        tests.add(test);
      }
    }
    assertEquals(3, tests.size());
  }
  
  @Test
  public void walkFile() throws IOException {
    Path folder = Paths.get("src", "test", "java");
    final List<Path> javaFiles = new ArrayList<>();
    Files.walkFileTree(folder, new SimpleFileVisitor<Path>() {
      @Override
      public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if (file.getFileName().toString().endsWith(".java")) {
          javaFiles.add(file);
        }
        return FileVisitResult.CONTINUE;
      }
    });
    assertTrue(javaFiles.size() > 5);
  }
  
  @Test
  public void fileAttributeViews() throws IOException {
    Path pom = Paths.get("pom.xml");
    BasicFileAttributeView view = Files.getFileAttributeView(pom, BasicFileAttributeView.class);
//    view.setTimes(null, null, null);
    
    BasicFileAttributes attributes = view.readAttributes();
    attributes = Files.readAttributes(pom, BasicFileAttributes.class);
    
    FileTime creationTime1 = attributes.creationTime();
    FileTime creationTime2 = (FileTime) Files.getAttribute(pom, "basic:creationTime");
    FileTime creationTime3 = (FileTime) Files.getAttribute(pom, "creationTime");
    assertEquals(creationTime1, creationTime2);
    assertEquals(creationTime2, creationTime3);
    
    Instant instant = creationTime1.toInstant();
    ZonedDateTime expected = ZonedDateTime.parse("2014-04-22T10:31:38Z");
    assertEquals(expected.toInstant(), instant);
  }

}