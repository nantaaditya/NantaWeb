package com.nanta.converter;

import com.nanta.base.Converter;
import com.nanta.dto.AboutDto;
import com.nanta.entity.About;

import ma.glasnost.orika.MapperFacade;

public class AboutConverter {
  private static final MapperFacade mapperFacade;

  static {
    Converter.MAPPER.classMap(About.class, AboutDto.class).byDefault().register();
    mapperFacade = Converter.MAPPER.getMapperFacade();
  }

  public static About toEntity(AboutDto dto) throws Exception {
    return mapperFacade.map(dto, About.class);
  }

  public static AboutDto toDto(About entity) throws Exception {
    return mapperFacade.map(entity, AboutDto.class);
  }
}
