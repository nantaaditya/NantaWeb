package com.nanta.converter;

import com.nanta.base.Converter;
import com.nanta.dto.ContactCaptchaDto;
import com.nanta.entity.Contact;

import ma.glasnost.orika.MapperFacade;

public class ContactCaptchaConverter {
  private static final MapperFacade mapperFacade;

  static {
    Converter.MAPPER.classMap(Contact.class, ContactCaptchaDto.class).byDefault().register();
    mapperFacade = Converter.MAPPER.getMapperFacade();
  }

  public static Contact toEntity(ContactCaptchaDto dto) throws Exception {
    return mapperFacade.map(dto, Contact.class);
  }

  public static ContactCaptchaDto toDto(Contact entity) throws Exception {
    return mapperFacade.map(entity, ContactCaptchaDto.class);
  }
}

