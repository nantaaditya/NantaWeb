package com.nanta.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nanta.base.CacheTopics;
import com.nanta.converter.EducationConverter;
import com.nanta.dto.EducationDto;
import com.nanta.repository.EducationRepository;
import com.nanta.service.EducationService;

@Service
@Transactional(readOnly = true)
public class EducationServiceImplementation implements EducationService {
  @Autowired
  private EducationRepository educationRepository;

  @Override
  @Transactional(readOnly = false, rollbackFor = Exception.class)
  @Cacheable(value = CacheTopics.EDUCATION)
  public void save(EducationDto educationDto) throws Exception {
    this.educationRepository.save(EducationConverter.toEntity(educationDto));
  }

  @Override
  @Transactional(readOnly = false, rollbackFor = Exception.class)
  @CacheEvict(value = CacheTopics.EDUCATION, allEntries = true)
  public void delete(String id) throws Exception {
    this.educationRepository.delete(id);;
  }

  @Override
  @Cacheable(value = CacheTopics.EDUCATION, condition = "#result != null")
  public List<EducationDto> findAll() throws Exception {
    return EducationConverter.toDtos(this.educationRepository.findAll());
  }

}
