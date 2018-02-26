package com.nanta.model;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class SingleResponse<T> extends BaseResponse {
  private T value;

  public SingleResponse() {}

  public SingleResponse(boolean success, String requestId, HttpStatus httpCode, String message,
      T value) {
    super(success, requestId, httpCode, message);
    this.value = value;
  }

  public T getValue() {
    return value;
  }

  public void setValue(T value) {
    this.value = value;
  }

}
