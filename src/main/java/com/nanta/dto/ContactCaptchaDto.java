package com.nanta.dto;

import com.nanta.validator.Required;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ContactCaptchaDto extends ContactDto {
  @Required(message = "please verify you're human")
  private String captchaResponse;
}
