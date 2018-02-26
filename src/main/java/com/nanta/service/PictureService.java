package com.nanta.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.nanta.dto.PictureDto;

public interface PictureService {
  void save(MultipartFile file, PictureDto pictureDto) throws Exception;

  List<PictureDto> findAll() throws Exception;

  List<PictureDto> findAllActive() throws Exception;

  void delete(String path, String id) throws Exception;

  void toggle(String id, boolean status) throws Exception;
}
