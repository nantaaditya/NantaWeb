package com.nanta.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nanta.converter.AboutConverter;
import com.nanta.dto.AboutDto;
import com.nanta.entity.About;
import com.nanta.repository.AboutRepository;
import com.nanta.service.AboutService;

@Service
@Transactional(readOnly = true)
public class AboutServiceImplementation implements AboutService {
  @Autowired
  private AboutRepository aboutRepository;

  @Transactional(readOnly = false, rollbackFor = Exception.class)
  @Override
  public void update(AboutDto aboutDto) throws Exception {
    About about = aboutRepository.findAll().get(0);
    about.setDescription(aboutDto.getDescription());
    aboutRepository.save(about);
  }

  @Override
  public AboutDto get() throws Exception {
    AboutDto aboutDto = AboutConverter.toDto(aboutRepository.findAll().get(0));
    return aboutDto;
  }
}
