package com.nanta.security;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.nanta.entity.User;
import com.nanta.exception.JwtInvalidAuthenticationTokenException;
import com.nanta.exception.UnauthorizedException;
import com.nanta.model.JwtAuthenticationToken;
import com.nanta.model.JwtUserDetails;
import com.nanta.repository.UserRepository;
import com.nanta.service.AuthenticateService;
import com.nanta.service.SessionService;
import com.nanta.util.Credential;

import io.jsonwebtoken.Claims;

@Component
public class JwtAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {
  private Logger log = Logger.getLogger(this.getClass());
  @Autowired
  private AuthenticateService authenticateService;
  @Autowired
  private SessionService sessionService;
  @Autowired
  private UserRepository userRepository;
  private boolean isAuthorized = false;

  @Override
  protected void additionalAuthenticationChecks(UserDetails userDetails,
      UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {}

  @Override
  protected UserDetails retrieveUser(String username,
      UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
    JwtAuthenticationToken jwtAuthenticationToken = (JwtAuthenticationToken) authentication;
    String jwtToken = jwtAuthenticationToken.getToken();
    Claims claims = this.authenticateService.parseJwtToken(jwtToken);

    if (claims == null) {
      throw new JwtInvalidAuthenticationTokenException("Invalid JWT token");
    }

    if (StringUtils.isEmpty(claims.getSubject())) {
      throw new JwtInvalidAuthenticationTokenException("Invalid JWT token");
    }
    User user;
    try {
      user = userRepository.findByUsername(claims.getSubject());
    } catch (Exception e) {
      log.error(e);
    }

    try {
      Credential.setUsername(claims.getSubject());
      Credential.setSessionId(String.valueOf(claims.get("sessionId")));
      isAuthorized = sessionService.isAuthorized();
    } catch (Exception e) {
      throw new UnauthorizedException(e.getMessage());
    }

    if (!isAuthorized) {
      throw new UnauthorizedException("Unauthorized api access");
    }

    return new JwtUserDetails(claims.getSubject(), jwtToken);
  }

  @Override
  public boolean supports(Class<?> authentication) {
    return JwtAuthenticationToken.class.isAssignableFrom(authentication);
  }

}
