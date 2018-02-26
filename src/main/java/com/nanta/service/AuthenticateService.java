package com.nanta.service;

import com.nanta.dto.ChangePasswordDto;
import com.nanta.entity.User;

import io.jsonwebtoken.Claims;

public interface AuthenticateService {
  String authenticate(String username, String password) throws Exception;

  String generateJwtToken(User user) throws Exception;

  Claims parseJwtToken(String jwtToken);

  void unauthenticate() throws Exception;

  void changePassword(ChangePasswordDto changePasswordDto) throws Exception;
}
