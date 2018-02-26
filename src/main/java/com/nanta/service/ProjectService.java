package com.nanta.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.nanta.dto.ProjectDto;

public interface ProjectService {
  void save(MultipartFile file, ProjectDto projectDto) throws Exception;

  List<ProjectDto> findAll() throws Exception;

  void delete(String path, String id) throws Exception;
}
