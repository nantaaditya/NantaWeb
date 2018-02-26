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
    Session savedSession = sessionRepository.findByUsername(username);
    if (savedSession != null) {
      sessionRepository.delete(savedSession.getId());
      sessionRepository.flush();
    }
    Session session = new Session(username, Credential.getSessionId(), Credential.getHostname());
    sessionRepository.save(session);
  }

  @Override
  public boolean isAuthorized() throws Exception {
    Session session = sessionRepository.findByUsernameAndSessionId(Credential.getUsername(),
        Credential.getSessionId());
    return session != null;
  }

  @Override
  @Transactional(readOnly = false, rollbackFor = Exception.class)
  public void remove() throws Exception {
    Session session = sessionRepository.findByUsernameAndSessionId(Credential.getUsername(),
        Credential.getSessionId());
    if (session != null) {
      sessionRepository.delete(session.getId());
    }
  }
}
