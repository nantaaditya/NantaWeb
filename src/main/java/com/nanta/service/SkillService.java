package com.nanta.service;

import java.util.List;

import com.nanta.dto.SkillDto;

public interface SkillService {
  void save(SkillDto skillDto) throws Exception;

  List<SkillDto> findAll() throws Exception;

  void delete(String id) throws Exception;
}
