package com.nanta.base;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class BaseConfiguration {
  @Value("${google.captcha.private.key}")
  private String CAPTCHA_PRIVATE_KEY;
  @Value("${application.base.url}")
  private String BASE_URL;

  public String getCaptchaPrivateKey() {
    return this.CAPTCHA_PRIVATE_KEY;
  }

  public String getBaseUrl(){
    return this.BASE_URL;
  }
}
