package com.nanta.converter;

import java.util.ArrayList;
import java.util.List;

import com.nanta.base.Converter;
import com.nanta.dto.PictureDto;
import com.nanta.entity.Picture;

import ma.glasnost.orika.MapperFacade;

public class PictureConverter {
  private static final MapperFacade mapperFacade;

  static {
    Converter.MAPPER.classMap(Picture.class, PictureDto.class).byDefault().register();
    mapperFacade = Converter.MAPPER.getMapperFacade();
  }

  public static Picture toEntity(PictureDto dto) throws Exception {
    return mapperFacade.map(dto, Picture.class);
  }

  public static PictureDto toDto(Picture entity) throws Exception {
    return mapperFacade.map(entity, PictureDto.class);
  }

  public static List<PictureDto> toDtos(List<Picture> entities) throws Exception {
    List<PictureDto> dtos = new ArrayList<>();
    for (Picture entity : entities) {
      dtos.add(toDto(entity));
    }
    return dtos;
  }
}
