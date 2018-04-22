package com.nanta.service;

import com.nanta.dto.AboutDto;

public interface AboutService {
  void update(AboutDto aboutDto) throws Exception;

  AboutDto getOne() throws Exception;
}
