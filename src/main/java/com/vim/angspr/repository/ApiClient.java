package com.vim.angspr.repository;

import org.springframework.web.client.RestTemplate;

public class ApiClient {

  public static VO post(VO newVO) {
    final String uri = "http://dummy.restapiexample.com/api/v1/create";

    RestTemplate restTemplate = new RestTemplate();
    VO result = restTemplate.postForObject(uri, newVO, VO.class);

    System.out.println(result);
    return result;
  }

}
