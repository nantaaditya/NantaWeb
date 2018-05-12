package com.nanta.dto;

import java.io.Serializable;

import com.nanta.validator.Required;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDto implements Serializable {
  @Required(message = "field username is required")
  private String username;
  @Required(message = "field password is required")
  private String password;
  @Required(message = "please verify you're human")
  private String captchaResponse;
}
