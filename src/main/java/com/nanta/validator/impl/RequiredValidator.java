package com.nanta.validator.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.util.StringUtils;

import com.nanta.validator.Required;

public class RequiredValidator implements ConstraintValidator<Required, String> {

  @Override
  public void initialize(Required constraintAnnotation) {}

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {    
    return !StringUtils.isEmpty(value);
  }

}
