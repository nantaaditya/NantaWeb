package com.nanta.converter;

import java.util.ArrayList;
import java.util.List;

import com.nanta.base.Converter;
import com.nanta.dto.EducationDto;
import com.nanta.entity.Education;

import ma.glasnost.orika.MapperFacade;

public class EducationConverter {
  private static final MapperFacade mapperFacade;

  static {
    Converter.MAPPER.classMap(Education.class, EducationDto.class).byDefault().register();
    mapperFacade = Converter.MAPPER.getMapperFacade();
  }

  public static Education toEntity(EducationDto dto) throws Exception {
    return mapperFacade.map(dto, Education.class);
  }

  public static EducationDto toDto(Education entity) throws Exception {
    return mapperFacade.map(entity, EducationDto.class);
  }

  public static List<EducationDto> toDtos(List<Education> entities) throws Exception {
    List<EducationDto> dtos = new ArrayList<>();
    for (Education entity : entities) {
      dtos.add(toDto(entity));
    }
    return dtos;
  }
}
