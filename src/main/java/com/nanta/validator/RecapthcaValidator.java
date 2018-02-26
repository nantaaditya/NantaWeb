package com.nanta.validator;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.nanta.dto.CaptchaResponse;

public class RecapthcaValidator {
  public static final String RECAPTCHA_VERIFY_URL =
      "https://www.google.com/recaptcha/api/siteverify";

  public static CaptchaResponse checkReCaptcha(String secret, String response) {
    MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
    map.add("secret", secret);
    map.add("response", response);
    RestTemplate restTemplate = new RestTemplate();
    return restTemplate.postForObject(RECAPTCHA_VERIFY_URL, map, CaptchaResponse.class);
  }
}
