package com.github.marschall.techzone.java7;

import static java.nio.charset.StandardCharsets.US_ASCII;
import static java.nio.file.StandardOpenOption.CREATE_NEW;
import static java.nio.file.StandardOpenOption.WRITE;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.github.marschall.memoryfilesystem.MemoryFileSystemBuilder;

public class MemoryFileSystemTest {
  
  private FileSystem fileSystem;

  @Before
  public void setUp() throws IOException {
    this.fileSystem = FileSystems.getDefault();
    this.fileSystem = MemoryFileSystemBuilder.newEmpty().build(this.getClass().getName());
  }
  
  @After
  public void tearDown() throws IOException {
    this.fileSystem.close();
  }
  
  @Test
  public void copy() throws IOException {
    Path source = this.fileSystem.getPath("src/demo/resources/data.sql");
    source = this.fileSystem.getPath("src").resolve("demo").resolve("resources").resolve("data.sql");
    source = this.fileSystem.getPath("src", "demo", "resources", "data.sql");
    
    Files.createDirectories(source.getParent());
    try (BufferedWriter output = Files.newBufferedWriter(source, US_ASCII)) {
      output.write("SELECT 1 FROM dual;");
    }
    
    
    Path target = this.fileSystem.getPath("target", "demo", "file.sql");
    Files.createDirectories(target.getParent());
    try {
      Files.copy(source, target);
    } finally {
      Files.deleteIfExists(target);
      Files.deleteIfExists(target.getParent());
    }
    
  }
  
  @Test
  public void pathOperations() {
    Path data = this.fileSystem.getPath("src", "demo", "resources", "data.sql");
    assertFalse(data.isAbsolute());
    
    assertEquals("src/demo/resources/data.sql", data.toString());
    
    assertEquals("src/demo/resources/schema.sql", data.getParent().resolve("schema.sql").toString());
    assertEquals("src/demo/resources/schema.sql", data.resolveSibling("schema.sql").toString());
    
    Path schema = this.fileSystem.getPath("schema.sql");
    assertEquals("src/demo/resources/schema.sql", data.getParent().resolve(schema).toString());
    assertEquals("src/demo/resources/schema.sql", data.resolveSibling(schema).toString());
    
    Path demoFolder = this.fileSystem.getPath("src", "demo");
    assertEquals("resources/data.sql", demoFolder.relativize(data).toString());
  }
  
  @Test
  public void options() throws IOException {
    Path data = this.fileSystem.getPath("data.sql");
    try (ByteChannel channel = Files.newByteChannel(data, CREATE_NEW, WRITE)) {
      ByteBuffer buffer = ByteBuffer.wrap("SELECT * FROM dual".getBytes(US_ASCII));
      int capacity = buffer.capacity();
      int written = 0;
      while (written < capacity) {
        written += channel.write(buffer);
      }
    }
    
  }

}
