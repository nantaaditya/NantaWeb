package com.nanta.model;

import java.io.Serializable;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BaseResponse implements Serializable {
  private boolean success = false;
  private String requestId;
  private HttpStatus httpCode;
  private String message;

  public BaseResponse(String requestId, HttpStatus httpCode, String message){
    this.requestId = requestId;
    this.httpCode = httpCode;
    this.message = message;
  }

  public BaseResponse(boolean success, String requestId, HttpStatus httpCode, String message) {
    this.success = success;
    this.requestId = requestId;
    this.httpCode = httpCode;
    this.message = message;
  }

  public boolean isSuccess() {
    return this.success;
  }

  public void setSuccess(boolean success) {
    this.success = success;
  }

  public String getRequestId() {
    return this.requestId;
  }

  public void setRequestId(String requestId) {
    this.requestId = requestId;
  }

  public HttpStatus getHttpCode() {
    return this.httpCode;
  }

  public void setHttpCode(HttpStatus httpCode) {
    this.httpCode = httpCode;
  }

  public String getMessage() {
    return this.message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
