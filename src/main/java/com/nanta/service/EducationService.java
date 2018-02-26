package com.nanta.service;

import java.util.List;

import com.nanta.dto.EducationDto;

public interface EducationService {
  void save(EducationDto educationDto) throws Exception;

  List<EducationDto> findAll() throws Exception;

  void delete(String id) throws Exception;
}
