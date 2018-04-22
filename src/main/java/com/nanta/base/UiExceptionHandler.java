package com.nanta.base;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.nanta.exception.PageNotFoundException;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice(basePackages = {"com.nanta"})
@Slf4j
public class UiExceptionHandler {
  @ExceptionHandler(PageNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public ModelAndView handlePageNotFound(HttpServletRequest request, HttpServletResponse response) {
    log.error(request.getRequestURI());
    ModelAndView model = new ModelAndView();
    model.setViewName("/404");
    return model;
  }
}
