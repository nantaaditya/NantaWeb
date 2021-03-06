package com.nanta.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.nanta.entity.Session;
import com.nanta.exception.InvalidException;
import com.nanta.repository.SessionRepository;
import com.nanta.service.SessionService;
import com.nanta.util.Credential;

@Service
@Transactional(readOnly = true)
public class SessionServiceImplementation implements SessionService {
  @Autowired
  private SessionRepository sessionRepository;

  @Override
  @Transactional(readOnly = false, rollbackFor = Exception.class)
  public void create(String username) throws Exception {
    if (StringUtils.isEmpty(username)) {
      throw new InvalidException("Invalid username");
    }
    Session savedSession = this.sessionRepository.findByUsername(username);
    if (savedSession != null) {
      this.sessionRepository.delete(savedSession.getId());
      this.sessionRepository.flush();
    }
    Session session = Session.builder().username(username).sessionId(Credential.getSessionId())
        .hostname(Credential.getHostname()).build();
    this.sessionRepository.save(session);
  }

  @Override
  public boolean isAuthorized() throws Exception {
    Session session = this.sessionRepository.findByUsernameAndSessionId(Credential.getUsername(),
        Credential.getSessionId());
    return session != null;
  }

  @Override
  @Transactional(readOnly = false, rollbackFor = Exception.class)
  public void remove() throws Exception {
    Session session = this.sessionRepository.findByUsernameAndSessionId(Credential.getUsername(),
        Credential.getSessionId());
    if (session != null) {
      this.sessionRepository.delete(session.getId());
    }
  }
}
