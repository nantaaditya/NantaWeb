package com.nanta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nanta.entity.Session;

@Repository
public interface SessionRepository extends JpaRepository<Session, String> {
  Session findByUsername(String username) throws Exception;

  Session findByUsernameAndSessionId(String username, String sessionId) throws Exception;
}
