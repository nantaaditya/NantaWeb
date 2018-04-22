package com.nanta.dto;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDto implements Serializable{
  private String username;
  private String password;
  private String captchaResponse;
}
