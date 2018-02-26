package com.nanta.converter;

import java.util.ArrayList;
import java.util.List;

import com.nanta.base.Converter;
import com.nanta.dto.ContactDto;
import com.nanta.entity.Contact;

import ma.glasnost.orika.MapperFacade;

public class ContactConverter {
  private static final MapperFacade mapperFacade;

  static {
    Converter.MAPPER.classMap(Contact.class, ContactDto.class).byDefault().register();
    mapperFacade = Converter.MAPPER.getMapperFacade();
  }

  public static Contact toEntity(ContactDto dto) throws Exception {
    return mapperFacade.map(dto, Contact.class);
  }

  public static ContactDto toDto(Contact entity) throws Exception {
    return mapperFacade.map(entity, ContactDto.class);
  }

  public static List<ContactDto> toDtos(List<Contact> entities) throws Exception {
    List<ContactDto> dtos = new ArrayList<>();
    for (Contact entity : entities) {
      dtos.add(toDto(entity));
    }
    return dtos;
  }
}
