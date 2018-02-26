package com.nanta.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nanta.converter.EducationConverter;
import com.nanta.dto.EducationDto;
import com.nanta.entity.Education;
import com.nanta.repository.EducationRepository;
import com.nanta.service.EducationService;

@Service
@Transactional(readOnly = true)
public class EducationServiceImplementation implements EducationService {
  @Autowired
  private EducationRepository educationRepository;

  @Override
  @Transactional(readOnly = false, rollbackFor = Exception.class)
  public void save(EducationDto educationDto) throws Exception {
    Education education = EducationConverter.toEntity(educationDto);
    educationRepository.save(education);
  }

  @Override
  @Transactional(readOnly = false, rollbackFor = Exception.class)
  public void delete(String id) throws Exception {
    educationRepository.delete(id);;
  }

  @Override
  public List<EducationDto> findAll() throws Exception {
    List<EducationDto> educationDtos = EducationConverter.toDtos(educationRepository.findAll());
    return educationDtos;
  }

}
