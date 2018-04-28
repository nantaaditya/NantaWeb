package com.nanta.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nanta.base.CacheTopics;
import com.nanta.converter.SkillConverter;
import com.nanta.dto.SkillDto;
import com.nanta.repository.SkillRepository;
import com.nanta.service.SkillService;

@Service
@Transactional(readOnly = true)
public class SkillServiceImplementation implements SkillService {
  @Autowired
  private SkillRepository skillRepository;

  @Override
  @Transactional(readOnly = false, rollbackFor = Exception.class)
  @Cacheable(value = CacheTopics.SKILL)
  public void save(SkillDto skillDto) throws Exception {
    this.skillRepository.save(SkillConverter.toEntity(skillDto));
  }

  @Override
  @Cacheable(value = CacheTopics.SKILL, condition = "#result != null")
  public List<SkillDto> findAll() throws Exception {
    return SkillConverter.toDtos(this.skillRepository.findAll());
  }

  @Override
  @Transactional(readOnly = false, rollbackFor = Exception.class)
  @CacheEvict(value = CacheTopics.SKILL, allEntries = true)
  public void delete(String id) throws Exception {
    this.skillRepository.delete(id);
  }

}
