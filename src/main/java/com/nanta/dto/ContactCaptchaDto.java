package com.nanta.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ContactCaptchaDto {
  private String id;
  private String name;
  private String email;
  private String message;
  private String status;
  private String captchaResponse;
}
