package com.nanta.service;

public interface SessionService {
  void create(String username) throws Exception;

  boolean isAuthorized() throws Exception;

  void remove() throws Exception;
}
