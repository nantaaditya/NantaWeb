package com.nanta.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nanta.converter.SkillConverter;
import com.nanta.dto.SkillDto;
import com.nanta.entity.Skill;
import com.nanta.repository.SkillRepository;
import com.nanta.service.SkillService;

@Service
@Transactional(readOnly = true)
public class SkillServiceImplementation implements SkillService {
  @Autowired
  private SkillRepository skillRepository;

  @Override
  @Transactional(readOnly = false, rollbackFor = Exception.class)
  public void save(SkillDto skillDto) throws Exception {
    Skill skill = SkillConverter.toEntity(skillDto);
    skillRepository.save(skill);
  }

  @Override
  public List<SkillDto> findAll() throws Exception {
    return SkillConverter.toDtos(skillRepository.findAll());
  }

  @Override
  @Transactional(readOnly = false, rollbackFor = Exception.class)
  public void delete(String id) throws Exception {
    skillRepository.delete(id);
  }

}
