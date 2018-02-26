package com.nanta.service.implementation;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nanta.converter.ContactCaptchaConverter;
import com.nanta.converter.ContactConverter;
import com.nanta.dto.ContactCaptchaDto;
import com.nanta.dto.ContactDto;
import com.nanta.dto.ReplyMessageDto;
import com.nanta.entity.Contact;
import com.nanta.repository.ContactRepository;
import com.nanta.service.ContactService;

@Service
@Transactional(readOnly = true)
public class ContactServiceImplementation implements ContactService {
  @Autowired
  private ContactRepository contactRepository;
  @Autowired
  public JavaMailSender emailSender;
  private Logger log = Logger.getLogger(this.getClass());

  @Override
  @Transactional(readOnly = false, rollbackFor = Exception.class)
  public void save(ContactCaptchaDto contactCaptchaDto) throws Exception {
    contactRepository.save(ContactCaptchaConverter.toEntity(contactCaptchaDto));
  }

  @Override
  public List<ContactDto> findAll() throws Exception {
    return ContactConverter.toDtos(contactRepository.findAll());
  }

  @Override
  @Transactional(readOnly = false, rollbackFor = Exception.class)
  public ContactDto findById(String id) throws Exception {
    Contact contact = contactRepository.findOne(id);
    contact.setStatus("read");
    contactRepository.save(contact);
    return ContactConverter.toDto(contact);
  }

  @Override
  @Transactional(readOnly = false, rollbackFor = Exception.class)
  public void reply(ReplyMessageDto replyMessageDto) throws Exception {
    Contact contact = contactRepository.findOne(replyMessageDto.getId());
    contact.setStatus("replied");
    contactRepository.save(contact);

    SimpleMailMessage msg = new SimpleMailMessage();
    try {
      msg.setTo(replyMessageDto.getEmail());
      msg.setSubject(replyMessageDto.getSubject());
      msg.setText(replyMessageDto.getMessage());
      emailSender.send(msg);
    } catch (Exception e) {
      log.error(e);
    }
  }

}
