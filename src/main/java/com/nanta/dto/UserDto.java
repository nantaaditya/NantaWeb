package com.nanta.dto;

public class UserDto {
  private String username;
  private String password;
  private String captchaResponse;

  public UserDto() {}

  public UserDto(String username) {
    this.username = username;
  }

  public UserDto(String username, String password) {
    this.username = username;
    this.password = password;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getCaptchaResponse() {
    return captchaResponse;
  }

  public void setCaptchaResponse(String captchaResponse) {
    this.captchaResponse = captchaResponse;
  }
}
