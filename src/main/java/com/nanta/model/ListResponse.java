package com.nanta.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ListResponse<T> extends BaseResponse {
  private List<T> content = new ArrayList<>();

  public ListResponse(boolean success, String requestId, HttpStatus httpCode, String message,
      List<T> content) {
    super(success, requestId, httpCode, message);
    this.content = content;
  }

  public List<T> getContent() {
    return this.content;
  }

  public void setContent(List<T> content) {
    this.content = content;
  }

}
