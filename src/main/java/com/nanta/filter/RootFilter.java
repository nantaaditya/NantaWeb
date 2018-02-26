package com.nanta.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;

public class RootFilter extends OncePerRequestFilter {

  @Override
  protected void doFilterInternal(HttpServletRequest httpServletRequest,
      HttpServletResponse httpServletResponse, FilterChain filterChain)
      throws ServletException, IOException {
    if ("/".equals(httpServletRequest.getRequestURI())) {
      httpServletResponse.sendRedirect("/home");
    } else {
      filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
  }

}
