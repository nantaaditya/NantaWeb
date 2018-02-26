package com.nanta.service;

import java.util.List;

import com.nanta.dto.ContactCaptchaDto;
import com.nanta.dto.ContactDto;
import com.nanta.dto.ReplyMessageDto;

public interface ContactService {
  void save(ContactCaptchaDto contactCaptchaDto) throws Exception;

  List<ContactDto> findAll() throws Exception;

  ContactDto findById(String id) throws Exception;

  void reply(ReplyMessageDto replyMessageDto) throws Exception;
}
