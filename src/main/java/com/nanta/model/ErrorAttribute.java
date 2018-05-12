package com.nanta.model;

import org.springframework.validation.FieldError;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorAttribute {  
  private String attributeName;
  private String message;

  public ErrorAttribute(FieldError fieldError) {
    this.attributeName = fieldError.getField();
    this.message = fieldError.getDefaultMessage();
  }

}
