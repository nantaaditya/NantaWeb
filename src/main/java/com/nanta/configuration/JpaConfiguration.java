package com.nanta.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.nanta.model.JwtAuditorAware;

@Configuration
@EnableJpaAuditing
public class JpaConfiguration {
  @Bean
  public JwtAuditorAware auditorAware() throws Exception {
    return new JwtAuditorAware();
  }
}
