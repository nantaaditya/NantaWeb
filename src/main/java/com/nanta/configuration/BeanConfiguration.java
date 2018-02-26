package com.nanta.configuration;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class BeanConfiguration {

  @Bean
  public ObjectMapper objectMapper() throws Exception {
    ObjectMapper objectMapper = new ObjectMapper(new JsonFactory());
    return objectMapper;
  }

  @Bean
  public RestTemplate restTemplate(RestTemplateBuilder builder) throws Exception {
    return builder.build();
  }

}
