package com.nanta.validator;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.nanta.base.RegexType;
import com.nanta.validator.impl.RegexValidator;

@Target({FIELD, METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = RegexValidator.class)
@Documented
public @interface Regex {
  RegexType type();

  String message() default "field is not valid";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
