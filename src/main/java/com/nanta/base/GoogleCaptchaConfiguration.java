package com.nanta.base;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class GoogleCaptchaConfiguration {
  @Value("${google.captcha.private.key}")
  private String CAPTCHA_PRIVATE_KEY;

  public String getCaptchaPrivateKey() {
    return this.CAPTCHA_PRIVATE_KEY;
  }
}
