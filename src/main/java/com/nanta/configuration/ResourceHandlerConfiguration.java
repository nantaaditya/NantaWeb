package com.nanta.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.nanta.service.FileService;

@Configuration
@Component
public class ResourceHandlerConfiguration extends WebMvcConfigurerAdapter {
  @Autowired
  private FileService fileService;

  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler("/resource/**")
        .addResourceLocations("file:" + fileService.getFilePath() + "/").setCachePeriod(500);
  }
}
