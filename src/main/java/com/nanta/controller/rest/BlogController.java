package com.nanta.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nanta.base.ApiPath;
import com.nanta.dto.BlogDto;
import com.nanta.dto.PostDto;
import com.nanta.model.BaseResponse;
import com.nanta.model.ListResponse;
import com.nanta.model.SingleResponse;
import com.nanta.service.BlogService;
import com.nanta.validator.Validator;

@RestController
@RequestMapping(value = ApiPath.BLOG)
public class BlogController {
  @Autowired
  private BlogService blogService;
  private ObjectMapper objectMapper = new ObjectMapper();

  @RequestMapping(method = RequestMethod.POST, consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
  public BaseResponse save(@RequestParam String requestId, @RequestPart MultipartFile file,
      @RequestPart String postDto) throws Exception {
    PostDto post = objectMapper.readValue(postDto, PostDto.class);
    Validator.checkSaveBlog(post);
    blogService.save(file, post);
    return new BaseResponse(true, requestId, HttpStatus.OK, "Save post success.");
  }

  @RequestMapping(method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
  public ListResponse<BlogDto> findAll(@RequestParam String requestId) throws Exception {
    return new ListResponse<>(true, requestId, HttpStatus.OK, "Find all post success.",
        blogService.findAll());
  }

  @RequestMapping(method = RequestMethod.PUT, consumes = {MediaType.APPLICATION_JSON_VALUE})
  public BaseResponse update(@RequestParam String requestId, @RequestBody PostDto postDto)
      throws Exception {
    blogService.update(postDto);
    return new BaseResponse(true, requestId, HttpStatus.OK, "Update post success.");
  }

  @RequestMapping(value = "/{id}/{status}", method = RequestMethod.PUT,
      produces = {MediaType.APPLICATION_JSON_VALUE})
  public BaseResponse toggle(@RequestParam String requestId, @PathVariable String id,
      @PathVariable boolean status) throws Exception {
    blogService.toggle(id, status);
    return new BaseResponse(true, requestId, HttpStatus.OK, "Toggle post success.");
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE,
      produces = {MediaType.APPLICATION_JSON_VALUE})
  public BaseResponse delete(@RequestParam String requestId, @PathVariable String id)
      throws Exception {
    blogService.delete(id);
    return new BaseResponse(true, requestId, HttpStatus.OK, "Delete post success.");
  }

  @RequestMapping(value = "/{url}", method = RequestMethod.GET,
      produces = {MediaType.APPLICATION_JSON_VALUE})
  public SingleResponse<PostDto> findByUrl(@RequestParam String requestId, @PathVariable String url)
      throws Exception {
    return new SingleResponse<PostDto>(true, requestId, HttpStatus.OK, "Find by URL success.",
        blogService.findByUrl(url));
  }

  @RequestMapping(value = "/active", method = RequestMethod.GET,
      produces = {MediaType.APPLICATION_JSON_VALUE})
  public ListResponse<BlogDto> findAllActive(@RequestParam String requestId) throws Exception {
    return new ListResponse<>(true, requestId, HttpStatus.OK, "Find active post success.",
        blogService.findAllActive());
  }
}
