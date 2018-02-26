package com.nanta.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nanta.base.ApiPath;
import com.nanta.dto.PictureDto;
import com.nanta.model.BaseResponse;
import com.nanta.model.ListResponse;
import com.nanta.service.PictureService;
import com.nanta.validator.Validator;

@RestController
@RequestMapping(value = ApiPath.PICTURE)
public class PictureController {
  @Autowired
  private PictureService pictureService;
  private ObjectMapper objectMapper = new ObjectMapper();

  @RequestMapping(method = RequestMethod.POST, consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
  public BaseResponse save(@RequestParam String requestId, @RequestPart MultipartFile file,
      @RequestPart String pictureDto) throws Exception {
    PictureDto dto = objectMapper.readValue(pictureDto, PictureDto.class);
    pictureService.save(file, dto);
    Validator.checkSavePicture(dto);
    pictureService.save(file, dto);
    return new BaseResponse(true, requestId, HttpStatus.OK, "Save picture success.");
  }

  @RequestMapping(method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
  public ListResponse<PictureDto> findAll(@RequestParam String requestId) throws Exception {
    return new ListResponse<>(true, requestId, HttpStatus.OK, "Get picture success.",
        pictureService.findAll());
  }

  @RequestMapping(method = RequestMethod.DELETE, produces = {MediaType.APPLICATION_JSON_VALUE})
  public BaseResponse delete(@RequestParam String requestId, @RequestParam String path,
      @RequestParam String id) throws Exception {
    Validator.checkDelete(id);
    pictureService.delete(path, id);
    return new BaseResponse(true, requestId, HttpStatus.OK, "Delete picture success.");
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.PUT,
      produces = {MediaType.APPLICATION_JSON_VALUE})
  public BaseResponse toggle(@RequestParam String requestId, @PathVariable String id,
      @RequestParam boolean status) throws Exception {
    pictureService.toggle(id, status);
    return new BaseResponse(true, requestId, HttpStatus.OK, "Toggle picture status.");
  }

  @RequestMapping(value = "/{status}", method = RequestMethod.GET,
      produces = {MediaType.APPLICATION_JSON_VALUE})
  public ListResponse<PictureDto> findAllActive(@RequestParam String requestId,
      @PathVariable boolean status) throws Exception {
    return new ListResponse<>(true, requestId, HttpStatus.OK, "Get picture active success.",
        pictureService.findAllActive());
  }
}
