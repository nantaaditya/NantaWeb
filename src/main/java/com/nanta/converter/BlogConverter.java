package com.nanta.converter;

import java.util.ArrayList;
import java.util.List;

import com.nanta.base.Converter;
import com.nanta.dto.BlogDto;
import com.nanta.entity.Blog;

import ma.glasnost.orika.MapperFacade;

public class BlogConverter {

  private static final MapperFacade mapperFacade;

  static {
    Converter.MAPPER.classMap(Blog.class, BlogDto.class).byDefault().register();
    mapperFacade = Converter.MAPPER.getMapperFacade();
  }

  public static BlogDto toDto(Blog entity) throws Exception {
    return mapperFacade.map(entity, BlogDto.class);
  }

  public static List<BlogDto> toDtos(List<Blog> entities) throws Exception {
    List<BlogDto> dtos = new ArrayList<>();
    for (Blog entity : entities) {
      dtos.add(toDto(entity));
    }
    return dtos;
  }
}
