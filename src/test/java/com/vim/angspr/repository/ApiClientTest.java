package com.vim.angspr.repository;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ApiClientTest {

  @Before
  public void setUp() throws Exception {
  }

  @Test
  public void testPost() {
    double randKey = Math.random() * (999 - 100) + 100;
    String expected = "{\"name\":\"vim"+randKey+"\",\"salary\":\"123K\",\"age\":\"23\",\"id\":\"161629\"}";
    VO newVO = VO.builder()
      .name("VIM" + randKey)
      .salary("500K")
      .age(21)
      .build();
    String actual = ApiClient.post(newVO).toString();
    assertEquals(expected, actual);
  }

}
