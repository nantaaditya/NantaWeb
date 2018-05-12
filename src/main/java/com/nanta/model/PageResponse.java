package com.nanta.model;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PageResponse<T> extends BaseResponse {
  private Page<T> content;

  public PageResponse(boolean success, String requestId, HttpStatus httpCode, String message,
      Page<T> content) {
    super(success, requestId, httpCode, message);
    this.content = content;
  }

  public Page<T> getContent() {
    return this.content;
  }

  public void setContent(Page<T> content) {
    this.content = content;
  }

}
