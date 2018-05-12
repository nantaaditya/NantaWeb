package com.nanta.validator.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.nanta.base.RegexType;
import com.nanta.util.RegexMatchers;
import com.nanta.validator.Regex;

public class RegexValidator implements ConstraintValidator<Regex, String> {
  private RegexType type;

  @Override
  public void initialize(Regex regex) {
    this.type = regex.type();
  }

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    return RegexMatchers.isValid(this.type, value);
  }

}
