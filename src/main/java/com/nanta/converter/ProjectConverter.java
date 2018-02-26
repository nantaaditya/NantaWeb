package com.nanta.converter;

import java.util.ArrayList;
import java.util.List;

import com.nanta.base.Converter;
import com.nanta.dto.ProjectDto;
import com.nanta.entity.Project;

import ma.glasnost.orika.MapperFacade;

public class ProjectConverter {
  private static final MapperFacade mapperFacade;

  static {
    Converter.MAPPER.classMap(Project.class, ProjectDto.class).byDefault().register();
    mapperFacade = Converter.MAPPER.getMapperFacade();
  }

  public static Project toEntity(ProjectDto dto) throws Exception {
    return mapperFacade.map(dto, Project.class);
  }

  public static ProjectDto toDto(Project entity) throws Exception {
    return mapperFacade.map(entity, ProjectDto.class);
  }

  public static List<ProjectDto> toDtos(List<Project> entities) throws Exception {
    List<ProjectDto> dtos = new ArrayList<>();
    for (Project entity : entities) {
      dtos.add(toDto(entity));
    }
    return dtos;
  }

}
