package com.nanta.dto;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CaptchaResponse implements Serializable {
  @JsonProperty
  private Boolean success;

  @JsonProperty("error-codes")
  private List<String> errorCodes;

  public Boolean getSuccess() {
    return this.success;
  }

  public void setSuccess(Boolean success) {
    this.success = success;
  }

  public List<String> getErrorCodes() {
    return this.errorCodes;
  }

  public void setErrorCodes(List<String> errorCodes) {
    this.errorCodes = errorCodes;
  }

}
