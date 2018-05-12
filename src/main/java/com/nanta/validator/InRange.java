package com.nanta.validator;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.nanta.validator.impl.InRangeValidator;

@Target({FIELD, METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = InRangeValidator.class)
@Documented
public @interface InRange {
  int min() default 0;

  int max() default 100;

  String message() default "field must be in range";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}