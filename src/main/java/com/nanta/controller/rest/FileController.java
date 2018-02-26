package com.nanta.controller.rest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nanta.base.ApiPath;
import com.nanta.service.FileService;

@RestController
@RequestMapping(value = ApiPath.STATIC)
public class FileController {
  @Autowired
  private FileService fileService;

  @RequestMapping(value = "/web/{name}", method = RequestMethod.GET,
      produces = {MediaType.IMAGE_JPEG_VALUE})
  public void getProjectImage(@PathVariable String name, HttpServletResponse response)
      throws IOException {
    String path = fileService.getFilePath();
    File file = new File(path + "/web/" + name + ".jpg");
    System.out.println(file.exists());
    InputStream inputStream = new FileInputStream(file);
    System.out.println(file.getAbsolutePath());
    StreamUtils.copy(inputStream, response.getOutputStream());
  }

  @RequestMapping(value = "/gallery/{name}", method = RequestMethod.GET,
      produces = {MediaType.IMAGE_JPEG_VALUE})
  public void getImageGallery(@PathVariable String name, HttpServletResponse response)
      throws IOException {
    String path = fileService.getFilePath();
    File file = new File(path + "/gallery/" + name + ".jpg");
    System.out.println(file.exists());
    InputStream inputStream = new FileInputStream(file);
    System.out.println(file.getAbsolutePath());
    StreamUtils.copy(inputStream, response.getOutputStream());
  }

  @RequestMapping(value = "/post/{name}", method = RequestMethod.GET,
      produces = {MediaType.IMAGE_JPEG_VALUE})
  public void getImagePost(@PathVariable String name, HttpServletResponse response)
      throws IOException {
    String path = fileService.getFilePath();
    File file = new File(path + "/post/" + name + ".jpg");
    System.out.println(file.exists());
    InputStream inputStream = new FileInputStream(file);
    System.out.println(file.getAbsolutePath());
    StreamUtils.copy(inputStream, response.getOutputStream());
  }
}
