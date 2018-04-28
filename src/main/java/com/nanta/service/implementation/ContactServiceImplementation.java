package com.nanta.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nanta.base.CacheTopics;
import com.nanta.converter.ContactCaptchaConverter;
import com.nanta.converter.ContactConverter;
import com.nanta.dto.ContactCaptchaDto;
import com.nanta.dto.ContactDto;
import com.nanta.dto.ReplyMessageDto;
import com.nanta.entity.Contact;
import com.nanta.repository.ContactRepository;
import com.nanta.service.ContactService;

import lombok.extern.slf4j.Slf4j;

@Service
@Transactional(readOnly = true)
@Slf4j
public class ContactServiceImplementation implements ContactService {
  @Autowired
  private ContactRepository contactRepository;
  @Autowired
  public JavaMailSender emailSender;

  @Override
  @Transactional(readOnly = false, rollbackFor = Exception.class)
  @Cacheable(value = CacheTopics.EMAIL)
  public void save(ContactCaptchaDto contactCaptchaDto) throws Exception {
    this.contactRepository.save(ContactCaptchaConverter.toEntity(contactCaptchaDto));
  }

  @Override
  @Cacheable(value = CacheTopics.EMAIL, condition = "#result!=null")
  public List<ContactDto> findAll() throws Exception {
    return ContactConverter.toDtos(this.contactRepository.findAll());
  }

  @Override
  @Transactional(readOnly = false, rollbackFor = Exception.class)
  public ContactDto findById(String id) throws Exception {
    Contact contact = this.contactRepository.findOne(id);
    if (contact.getStatus().equalsIgnoreCase("unread")) {
      contact.setStatus("read");
    }
    this.contactRepository.save(contact);
    return ContactConverter.toDto(contact);
  }

  @Override
  @Transactional(readOnly = false, rollbackFor = Exception.class)
  public void reply(ReplyMessageDto replyMessageDto) throws Exception {
    long startDate = System.currentTimeMillis();
    Contact contact = this.contactRepository.findOne(replyMessageDto.getId());
    if (contact.getStatus().equalsIgnoreCase("read")) {
      contact.setStatus("replied");
    }
    this.contactRepository.save(contact);

    SimpleMailMessage msg = new SimpleMailMessage();
    try {
      msg.setTo(replyMessageDto.getEmail());
      msg.setSubject(replyMessageDto.getSubject());
      msg.setText(replyMessageDto.getMessage());
      msg.setFrom("personal@nantaaditya.com");
      this.emailSender.send(msg);
    } catch (Exception e) {
      log.error(e.getCause().toString());
    }
    log.info("sending email to: {}, message: {}, time to send: {} in ms",
        replyMessageDto.getEmail(), replyMessageDto.getEmail(),
        System.currentTimeMillis() - startDate);
  }

}
