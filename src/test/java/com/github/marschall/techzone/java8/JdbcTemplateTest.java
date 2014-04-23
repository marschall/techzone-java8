package com.github.marschall.techzone.java8;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

@ContextConfiguration(classes = JdbcConfiguration.class)
public class JdbcTemplateTest extends AbstractTransactionalJUnit4SpringContextTests {
  
  @Autowired
  private JdbcTemplate jdbcTemplate;

  @Test
  public void query() {
    Foo foo = this.jdbcTemplate.queryForObject("SELECT ID, NAME FROM T_FOO WHERE ID = 1",
        (rs, i) -> new Foo(rs.getInt("ID"), rs.getString("name")));
    assertNotNull(foo);
  }
  
  static final class Foo {
    private final int id;
    private final String name;
    
    Foo(int id, String name) {
      this.id = id;
      this.name = name;
    }
    
    
  }

}
