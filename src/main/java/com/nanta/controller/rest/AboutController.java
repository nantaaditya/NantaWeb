package com.nanta.controller.rest;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nanta.base.ApiPath;
import com.nanta.dto.AboutDto;
import com.nanta.model.BaseResponse;
import com.nanta.model.SingleResponse;
import com.nanta.service.AboutService;

@RestController
@RequestMapping(value = ApiPath.ABOUT)
public class AboutController {
  @Autowired
  private AboutService aboutService;

  @RequestMapping(method = RequestMethod.PUT, consumes = {MediaType.APPLICATION_JSON_VALUE})
  public BaseResponse update(@RequestParam String requestId, @RequestBody @Valid AboutDto aboutDto)
      throws Exception {
    this.aboutService.update(aboutDto);
    return new BaseResponse(true, requestId, HttpStatus.OK, "Update about success");
  }

  @RequestMapping(method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
  @Cacheable(cacheNames = "about")
  public SingleResponse<AboutDto> getOne(@RequestParam String requestId) throws Exception {
    return new SingleResponse<AboutDto>(true, requestId, HttpStatus.OK, "Get about success",
        this.aboutService.getOne());
  }
}
