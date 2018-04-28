package com.nanta.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nanta.base.CacheTopics;
import com.nanta.converter.AboutConverter;
import com.nanta.dto.AboutDto;
import com.nanta.entity.About;
import com.nanta.repository.AboutRepository;
import com.nanta.service.AboutService;

import lombok.extern.slf4j.Slf4j;

@Service
@Transactional(readOnly = true)
@CacheEvict(value = CacheTopics.ABOUT, allEntries = true)
@Slf4j
public class AboutServiceImplementation implements AboutService {
  @Autowired
  private AboutRepository aboutRepository;

  @Transactional(readOnly = false, rollbackFor = Exception.class)
  @Override
  public void update(AboutDto aboutDto) throws Exception {
    About about = this.aboutRepository.findAll().get(0);
    about.setDescription(aboutDto.getDescription());
    this.aboutRepository.save(about);
  }

  @Override
  @Cacheable(value = CacheTopics.ABOUT, condition = "#result != null")
  public AboutDto getOne() throws Exception {
    log.debug(CacheTopics.ABOUT);
    return AboutConverter.toDto(this.aboutRepository.findAll().get(0));
  }
}
