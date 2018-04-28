package com.nanta.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nanta.base.ApiPath;
import com.nanta.base.GoogleCaptchaConfiguration;
import com.nanta.dto.CaptchaResponse;
import com.nanta.dto.ChangePasswordDto;
import com.nanta.dto.UserDto;
import com.nanta.model.BaseResponse;
import com.nanta.model.SingleResponse;
import com.nanta.service.AuthenticateService;
import com.nanta.validator.RecapthcaValidator;

@RestController
public class AuthenticateController {
  @Autowired
  private AuthenticateService authenticateService;
  @Autowired
  private GoogleCaptchaConfiguration baseConfiguration;

  @RequestMapping(value = ApiPath.LOGIN, method = RequestMethod.POST,
      consumes = {MediaType.APPLICATION_JSON_VALUE})
  public SingleResponse<String> login(@RequestParam String requestId, @RequestBody UserDto userDto)
      throws Exception {
    CaptchaResponse captchaResponse = RecapthcaValidator
        .checkReCaptcha(baseConfiguration.getCaptchaPrivateKey(), userDto.getCaptchaResponse());
    if (captchaResponse.getSuccess()) {
      String jwtToken =
          authenticateService.authenticate(userDto.getUsername(), userDto.getPassword());
      return new SingleResponse<String>(true, requestId, HttpStatus.OK, "logged in", jwtToken);
    } else
      return new SingleResponse<String>(false, requestId, HttpStatus.BAD_REQUEST,
          "Please verify you're human", null);
  }

  @RequestMapping(value = ApiPath.LOGOUT, method = RequestMethod.GET)
  public BaseResponse logout(@RequestParam String requestId) throws Exception {
    authenticateService.unauthenticate();
    return new BaseResponse(true, requestId, HttpStatus.OK, "logged out");
  }

  @RequestMapping(value = ApiPath.CHANGE_PASSWORD, method = RequestMethod.POST,
      consumes = {MediaType.APPLICATION_JSON_VALUE})
  public BaseResponse changePassword(@RequestParam String requestId,
      @RequestBody ChangePasswordDto changePasswordDto) throws Exception {
    authenticateService.changePassword(changePasswordDto);
    return new BaseResponse(true, requestId, HttpStatus.OK, "change password success");
  }
}
