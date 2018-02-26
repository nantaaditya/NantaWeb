package com.nanta.converter;

import java.util.ArrayList;
import java.util.List;

import com.nanta.base.Converter;
import com.nanta.dto.PostDto;
import com.nanta.entity.Blog;

import ma.glasnost.orika.MapperFacade;

public class PostConverter {

  private static final MapperFacade mapperFacade;

  static {
    Converter.MAPPER.classMap(Blog.class, PostDto.class).byDefault().register();
    mapperFacade = Converter.MAPPER.getMapperFacade();
  }

  public static Blog toEntity(PostDto dto) throws Exception {
    return mapperFacade.map(dto, Blog.class);
  }

  public static PostDto toDto(Blog entity) throws Exception {
    return mapperFacade.map(entity, PostDto.class);
  }

  public static List<PostDto> toDtos(List<Blog> entities) throws Exception {
    List<PostDto> dtos = new ArrayList<>();
    for (Blog entity : entities) {
      dtos.add(toDto(entity));
    }
    return dtos;
  }

}
