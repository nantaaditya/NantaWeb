package com.nanta.exception;

import org.springframework.security.core.AuthenticationException;

public class JwtInvalidAuthenticationTokenException extends AuthenticationException {

  public JwtInvalidAuthenticationTokenException(String msg) {
    super(msg);
  }
}