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

  public BaseResponse() {}

  public BaseResponse(HttpStatus httpCode, String message){    
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
    return success;
  }

  public void setSuccess(boolean success) {
    this.success = success;
  }

  public String getRequestId() {
    return requestId;
  }

  public void setRequestId(String requestId) {
    this.requestId = requestId;
  }

  public HttpStatus getHttpCode() {
    return httpCode;
  }

  public void setHttpCode(HttpStatus httpCode) {
    this.httpCode = httpCode;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
