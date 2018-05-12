package com.nanta.controller.rest;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nanta.base.ApiPath;
import com.nanta.dto.EducationDto;
import com.nanta.model.BaseResponse;
import com.nanta.model.ListResponse;
import com.nanta.service.EducationService;
import com.nanta.validator.Validator;

@RestController
@RequestMapping(value = ApiPath.EDUCATION)
public class EducationController {
  @Autowired
  private EducationService educationService;

  @RequestMapping(method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
  public BaseResponse save(@RequestParam String requestId,
      @RequestBody @Valid EducationDto educationDto) throws Exception {
    this.educationService.save(educationDto);
    return new BaseResponse(true, requestId, HttpStatus.OK, "Save education success");
  }

  @RequestMapping(method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
  public ListResponse<EducationDto> findAll(@RequestParam String requestId) throws Exception {
    return new ListResponse<>(true, requestId, HttpStatus.OK, "Get education success",
        this.educationService.findAll());
  }

  @RequestMapping(method = RequestMethod.DELETE, produces = {MediaType.APPLICATION_JSON_VALUE})
  public BaseResponse delete(@RequestParam String requestId, @RequestParam String id)
      throws Exception {
    Validator.checkId(id);
    this.educationService.delete(id);
    return new BaseResponse(true, requestId, HttpStatus.OK, "Delete education success");
  }
}
