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
import com.nanta.dto.SkillDto;
import com.nanta.model.BaseResponse;
import com.nanta.model.ListResponse;
import com.nanta.service.SkillService;
import com.nanta.validator.Validator;

@RestController
@RequestMapping(value = ApiPath.SKILL)
public class SkillController {
  @Autowired
  private SkillService skillService;

  @RequestMapping(method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
  public BaseResponse save(@RequestParam String requestId, @RequestBody SkillDto skillDto)
      throws Exception {
    Validator.checkSaveSkill(skillDto);
    skillService.save(skillDto);
    return new BaseResponse(true, requestId, HttpStatus.OK, "Save skill success.");
  }

  @RequestMapping(method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
  public ListResponse<SkillDto> findAll(@RequestParam String requestId) throws Exception {
    return new ListResponse<>(true, requestId, HttpStatus.OK, "Get skill success",
        skillService.findAll());
  }

  @RequestMapping(method = RequestMethod.DELETE, produces = {MediaType.APPLICATION_JSON_VALUE})
  public BaseResponse delete(@RequestParam String requestId, @RequestParam String id)
      throws Exception {
    Validator.checkDelete(id);
    skillService.delete(id);
    return new BaseResponse(true, requestId, HttpStatus.OK, "Delete skill success");
  }
}
