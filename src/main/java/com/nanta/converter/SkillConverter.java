package com.nanta.converter;

import java.util.ArrayList;
import java.util.List;

import com.nanta.base.Converter;
import com.nanta.dto.SkillDto;
import com.nanta.entity.Skill;

import ma.glasnost.orika.MapperFacade;

public class SkillConverter {
  private static final MapperFacade mapperFacade;

  static {
    Converter.MAPPER.classMap(Skill.class, SkillDto.class).byDefault().register();
    mapperFacade = Converter.MAPPER.getMapperFacade();
  }

  public static Skill toEntity(SkillDto dto) throws Exception {
    return mapperFacade.map(dto, Skill.class);
  }

  public static SkillDto toDto(Skill entity) throws Exception {
    return mapperFacade.map(entity, SkillDto.class);
  }

  public static List<SkillDto> toDtos(List<Skill> entities) throws Exception {
    List<SkillDto> dtos = new ArrayList<>();
    for (Skill entity : entities) {
      dtos.add(toDto(entity));
    }
    return dtos;
  }
}
