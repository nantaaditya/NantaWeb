package com.nanta.validator.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.nanta.validator.InRange;

public class InRangeValidator implements ConstraintValidator<InRange, Double> {
  private int min;
  private int max;

  @Override
  public void initialize(InRange constraintAnnotation) {
    this.min = constraintAnnotation.min();
    this.max = constraintAnnotation.max();
  }

  @Override
  public boolean isValid(Double value, ConstraintValidatorContext context) {
    return ((value >= this.min) && (value <= this.max));
  }

}
