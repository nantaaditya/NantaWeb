package com.nanta.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nanta.base.ApiPath;
import com.nanta.dto.ProjectDto;
import com.nanta.model.BaseResponse;
import com.nanta.model.ListResponse;
import com.nanta.service.ProjectService;
import com.nanta.validator.Validator;

@RestController
@RequestMapping(value = ApiPath.PROJECT)
public class ProjectController {
  @Autowired
  private ProjectService projectService;
  private ObjectMapper objectMapper = new ObjectMapper();

  @RequestMapping(method = RequestMethod.POST, consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
  public BaseResponse save(@RequestParam String requestId, @RequestPart MultipartFile file,
      @RequestPart String projectDto) throws Exception {
    ProjectDto dto = objectMapper.readValue(projectDto, ProjectDto.class);
    projectService.save(file, dto);
    Validator.checkSaveProject(dto);
    projectService.save(file, dto);
    return new BaseResponse(true, requestId, HttpStatus.OK, "Save project success.");
  }

  @RequestMapping(method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
  public ListResponse<ProjectDto> findAll(@RequestParam String requestId) throws Exception {
    return new ListResponse<>(true, requestId, HttpStatus.OK, "Get project success.",
        projectService.findAll());
  }

  @RequestMapping(method = RequestMethod.DELETE, produces = {MediaType.APPLICATION_JSON_VALUE})
  public BaseResponse delete(@RequestParam String requestId, @RequestParam String path,
      @RequestParam String id) throws Exception {
    Validator.checkDelete(id);
    projectService.delete(path, id);
    return new BaseResponse(true, requestId, HttpStatus.OK, "Delete project success.");
  }

}
