package com.nanta.controller.rest;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nanta.base.ApiPath;
import com.nanta.base.GoogleCaptchaConfiguration;
import com.nanta.dto.CaptchaResponse;
import com.nanta.dto.ContactCaptchaDto;
import com.nanta.dto.ContactDto;
import com.nanta.dto.ReplyMessageDto;
import com.nanta.model.BaseResponse;
import com.nanta.model.ListResponse;
import com.nanta.model.SingleResponse;
import com.nanta.service.ContactService;
import com.nanta.validator.Validator;

@RestController
@RequestMapping(value = ApiPath.CONTACT)
public class ContactController {
  @Autowired
  private ContactService contactService;
  @Autowired
  private GoogleCaptchaConfiguration googleCaptchaConfiguration;

  @RequestMapping(method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
  public BaseResponse save(@RequestParam String requestId,
      @RequestBody @Valid ContactCaptchaDto contactCaptchaDto) throws Exception {
    CaptchaResponse captchaResponse =
        Validator.checkReCaptcha(this.googleCaptchaConfiguration.getCaptchaPrivateKey(),
            contactCaptchaDto.getCaptchaResponse());
    if (captchaResponse.getSuccess()) {
      this.contactService.save(contactCaptchaDto);
      return new BaseResponse(true, requestId, HttpStatus.OK, "Your message has been sent.");
    }
    return new BaseResponse(false, requestId, HttpStatus.BAD_REQUEST,
        "Please verify you're human.");
  }

  @RequestMapping(method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
  public ListResponse<ContactDto> findAll(@RequestParam String requestId) throws Exception {
    return new ListResponse<>(true, requestId, HttpStatus.OK, "Get message success.",
        this.contactService.findAll());
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET,
      produces = {MediaType.APPLICATION_JSON_VALUE})
  public SingleResponse<ContactDto> findById(@RequestParam String requestId,
      @PathVariable String id) throws Exception {
    Validator.checkId(id);
    return new SingleResponse<ContactDto>(true, requestId, HttpStatus.OK,
        "Get message by id success.", this.contactService.findById(id));
  }

  @RequestMapping(value = "/reply", method = RequestMethod.POST,
      produces = {MediaType.APPLICATION_JSON_VALUE})
  public BaseResponse reply(@RequestParam String requestId,
      @RequestBody @Valid ReplyMessageDto replyMessageDto) throws Exception {
    this.contactService.reply(replyMessageDto);
    return new BaseResponse(true, requestId, HttpStatus.OK, "Reply message success.");
  }
}
