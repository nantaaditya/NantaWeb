package com.nanta.base;

import java.io.FileNotFoundException;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.tomcat.util.http.fileupload.FileUploadBase;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.nanta.exception.InvalidException;
import com.nanta.exception.PageNotFoundException;
import com.nanta.exception.UnauthorizedException;
import com.nanta.model.BaseResponse;

@ControllerAdvice(basePackages = {"com.nanta"})
public class BaseExceptionHandler {
  private static final Logger log = Logger.getLogger(BaseExceptionHandler.class);

  @ExceptionHandler(UnauthorizedException.class)
  @ResponseStatus(HttpStatus.UNAUTHORIZED)
  @ResponseBody
  public BaseResponse handleUnauthorizedException(HttpServletRequest req,
      UnauthorizedException ex) {
    log.error("Unathorized Access : " + req.getRequestURL());
    return new BaseResponse(HttpStatus.UNAUTHORIZED, ex.getMessage());
  }

  @ExceptionHandler(AuthenticationException.class)
  @ResponseStatus(HttpStatus.NETWORK_AUTHENTICATION_REQUIRED)
  @ResponseBody
  public BaseResponse handleJwtInvalidTokenException(HttpServletRequest req,
      AuthenticationException ex) {
    log.error("Newtwork Authentication Required : " + req.getRequestURL());
    return new BaseResponse(HttpStatus.NETWORK_AUTHENTICATION_REQUIRED, ex.getMessage());
  }

  @ExceptionHandler(BadCredentialsException.class)
  @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
  @ResponseBody
  public BaseResponse handleBadCredentialException(HttpServletRequest req,
      BadCredentialsException ex) {
    log.error("Bad Credential : " + req.getRequestURL());
    return new BaseResponse(HttpStatus.UNPROCESSABLE_ENTITY, ex.getMessage());
  }

  @ExceptionHandler(EntityExistsException.class)
  @ResponseStatus(HttpStatus.CONFLICT)
  @ResponseBody
  public BaseResponse handleEntityExistException(HttpServletRequest req, EntityExistsException ex) {
    log.error("Entity Exist : " + req.getRequestURL());
    return new BaseResponse(HttpStatus.CONFLICT, ex.getMessage());
  }

  @ExceptionHandler(EntityNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  @ResponseBody
  public BaseResponse handleEntityNotFoundException(HttpServletRequest req,
      EntityNotFoundException ex) {
    log.error("Entity Not Found : " + req.getRequestURL());
    return new BaseResponse(HttpStatus.NOT_FOUND, ex.getMessage());
  }

  @ExceptionHandler(FileNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  @ResponseBody
  public BaseResponse handleFileNotFoundException(HttpServletRequest req,
      FileNotFoundException ex) {
    log.error("Directory or File Not Found : " + req.getRequestURL());
    return new BaseResponse(HttpStatus.NOT_FOUND, ex.getMessage());
  }

  @ExceptionHandler(FileUploadBase.InvalidContentTypeException.class)
  @ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
  @ResponseBody
  public BaseResponse handleInvalidContentTypeException(HttpServletRequest req,
      FileUploadBase.InvalidContentTypeException ex) {
    log.error("File Upload Exception : " + req.getRequestURL());
    return new BaseResponse(HttpStatus.UNSUPPORTED_MEDIA_TYPE, ex.getMessage());
  }

  @ExceptionHandler(FileUploadBase.FileSizeLimitExceededException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ResponseBody
  public BaseResponse handleMaxFileUploadExceededException(HttpServletRequest req,
      FileUploadBase.FileSizeLimitExceededException ex) {
    log.error("File Upload Exception : " + req.getRequestURL());
    return new BaseResponse(HttpStatus.BAD_REQUEST, ex.getMessage());
  }

  @ExceptionHandler(InvalidException.class)
  @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
  @ResponseBody
  public BaseResponse handleInvalid(HttpServletRequest req, Exception ex) {
    log.error("Invalid Exception : " + req.getRequestURL());
    return new BaseResponse(HttpStatus.NOT_ACCEPTABLE, ex.getMessage());
  }

  @ExceptionHandler(PageNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public ModelAndView handlePageNotFound(HttpServletRequest request, HttpServletResponse response) {
    ModelAndView model = new ModelAndView();
    model.setViewName("/404");
    return model;
  }
}
