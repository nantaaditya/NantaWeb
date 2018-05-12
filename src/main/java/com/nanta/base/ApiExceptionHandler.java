package com.nanta.base;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;

import org.apache.tomcat.util.http.fileupload.FileUploadBase;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.nanta.exception.InvalidException;
import com.nanta.exception.UnauthorizedException;
import com.nanta.model.BaseResponse;
import com.nanta.model.ErrorAttribute;
import com.nanta.model.ListResponse;

import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice(basePackages = {"com.nanta"})
@Slf4j
public class ApiExceptionHandler {

  @ExceptionHandler(UnauthorizedException.class)
  @ResponseStatus(HttpStatus.UNAUTHORIZED)
  @ResponseBody
  public BaseResponse handleUnauthorizedException(HttpServletRequest req,
      UnauthorizedException ex) {
    log.error("Unathorized Access {}, from {} ", req.getRequestURL(), req.getRemoteAddr());
    return new BaseResponse(req.getRemoteAddr(), HttpStatus.UNAUTHORIZED, ex.getMessage());
  }

  @ExceptionHandler(AuthenticationException.class)
  @ResponseStatus(HttpStatus.NETWORK_AUTHENTICATION_REQUIRED)
  @ResponseBody
  public BaseResponse handleJwtInvalidTokenException(HttpServletRequest req,
      AuthenticationException ex) {
    log.error("Newtwork Authentication Required {}, from {} ", req.getRequestURL(),
        req.getRemoteAddr());
    return new BaseResponse(req.getRemoteAddr(), HttpStatus.NETWORK_AUTHENTICATION_REQUIRED,
        ex.getMessage());
  }

  @ExceptionHandler(BadCredentialsException.class)
  @ResponseStatus(HttpStatus.UNAUTHORIZED)
  @ResponseBody
  public BaseResponse handleBadCredentialException(HttpServletRequest req,
      BadCredentialsException ex) {
    log.error("Bad credential exception {}, from {} ", req.getRequestURL(), req.getRemoteAddr());
    return new BaseResponse(req.getRemoteAddr(), HttpStatus.UNAUTHORIZED, ex.getMessage());
  }

  @ExceptionHandler(EntityExistsException.class)
  @ResponseStatus(HttpStatus.CONFLICT)
  @ResponseBody
  public BaseResponse handleEntityExistException(HttpServletRequest req, EntityExistsException ex) {
    log.error("Entity exist exception {}, from {} ", req.getRequestURL(), req.getRemoteAddr());
    return new BaseResponse(req.getRemoteAddr(), HttpStatus.CONFLICT, ex.getMessage());
  }

  @ExceptionHandler(EntityNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  @ResponseBody
  public BaseResponse handleEntityNotFoundException(HttpServletRequest req,
      EntityNotFoundException ex) {
    log.error("Entity not found exception {}, from {} ", req.getRequestURL(), req.getRemoteAddr());
    return new BaseResponse(req.getRemoteAddr(), HttpStatus.NOT_FOUND, ex.getMessage());
  }

  @ExceptionHandler(FileNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  @ResponseBody
  public BaseResponse handleFileNotFoundException(HttpServletRequest req,
      FileNotFoundException ex) {
    log.error("Directory or file not found exception {}, from {} ", req.getRequestURL(),
        req.getRemoteAddr());
    return new BaseResponse(req.getRemoteAddr(), HttpStatus.NOT_FOUND, ex.getMessage());
  }

  @ExceptionHandler(FileUploadBase.InvalidContentTypeException.class)
  @ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
  @ResponseBody
  public BaseResponse handleInvalidContentTypeException(HttpServletRequest req,
      FileUploadBase.InvalidContentTypeException ex) {
    log.error("File upload invalid file type exception {},, from {} ", req.getRequestURL(),
        req.getRemoteAddr());
    return new BaseResponse(req.getRemoteAddr(), HttpStatus.UNSUPPORTED_MEDIA_TYPE,
        ex.getMessage());
  }

  @ExceptionHandler(FileUploadBase.FileSizeLimitExceededException.class)
  @ResponseStatus(HttpStatus.PAYLOAD_TOO_LARGE)
  @ResponseBody
  public BaseResponse handleMaxFileUploadExceededException(HttpServletRequest req,
      FileUploadBase.FileSizeLimitExceededException ex) {
    log.error("File upload size limit exception {}, , from {} ", req.getRequestURL(),
        req.getRemoteAddr());
    return new BaseResponse(req.getRemoteAddr(), HttpStatus.PAYLOAD_TOO_LARGE, ex.getMessage());
  }

  @ExceptionHandler(InvalidException.class)
  @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
  @ResponseBody
  public BaseResponse handleInvalid(HttpServletRequest req, Exception ex) {
    log.error("Invalid exception {}, from {} ", req.getRequestURL(), req.getRemoteAddr());
    return new BaseResponse(req.getRemoteAddr(), HttpStatus.NOT_ACCEPTABLE, ex.getMessage());
  }

  @ExceptionHandler(EmptyResultDataAccessException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ResponseBody
  public BaseResponse handleDataNotFound(HttpServletRequest req, Exception ex) {
    log.error("Data not found exception {}, from {} ", req.getRequestURL(), req.getRemoteAddr());
    return new BaseResponse(req.getRemoteAddr(), HttpStatus.BAD_REQUEST, "Data not found");
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ResponseBody
  public ListResponse<ErrorAttribute> handleMethodArgumentNotValid(HttpServletRequest req,
      MethodArgumentNotValidException ex) {
    log.error("Bad request exception {}, from {} ", req.getRequestURL(), req.getRemoteAddr());
    List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
    List<ErrorAttribute> errorAttributes =
        fieldErrors.stream().map(ErrorAttribute::new).collect(Collectors.toList());
    return new ListResponse<ErrorAttribute>(false, req.getRemoteAddr(), HttpStatus.BAD_REQUEST,
        "Bad request", errorAttributes);
  }
}
