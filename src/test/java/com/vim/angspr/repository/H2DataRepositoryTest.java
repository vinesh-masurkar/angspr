package com.vim.angspr.repository;

import com.vim.angspr.dto.TestData;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;

public class H2DataRepositoryTest {

  private H2DataRepository repository;

  @Before
  public void setUp() {
    repository = new H2DataRepository();
  }

  @Test
  public void testGetData() throws Exception {
    TestData expected = TestData.builder()
      .num(new Long(1))
      .dataname("Java")
      .build();

    TestData actual = repository.getData();
    Assert.assertNotNull((actual));
    Assert.assertThat(actual.getNum(), equalTo(expected.getNum()));
    Assert.assertThat(actual.getDataname(), equalTo(expected.getDataname()));
  }

}
