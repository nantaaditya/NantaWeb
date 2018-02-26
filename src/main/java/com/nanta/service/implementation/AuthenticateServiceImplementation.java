package com.nanta.service.implementation;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

import javax.persistence.EntityNotFoundException;
import javax.xml.bind.annotation.adapters.HexBinaryAdapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nanta.dto.ChangePasswordDto;
import com.nanta.entity.User;
import com.nanta.repository.UserRepository;
import com.nanta.service.AuthenticateService;
import com.nanta.service.SessionService;
import com.nanta.util.Credential;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
@Transactional(readOnly = true)
public class AuthenticateServiceImplementation implements AuthenticateService {
  @Autowired
  private SessionService sessionService;
  @Autowired
  private UserRepository userRepository;

  @Value("${jwt.secret.key}")
  private String jwtSecretKey;

  /**
   * GENERATE PASSWORD
   */
  private String generatePassword(String password) throws Exception {
    MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
    return (new HexBinaryAdapter())
        .marshal(messageDigest.digest(password.getBytes(StandardCharsets.UTF_8)));
  }

  /**
   * AUTHENTICATE
   */
  @Override
  @Transactional(readOnly = false, rollbackFor = Exception.class)
  public String authenticate(String username, String password) throws Exception {
    String digestedPassword = this.generatePassword(password);
    User user =
        userRepository.findByUsernameAndPasswordAndMarkForDeleteFalse(username, digestedPassword);
    if (user == null) {
      throw new BadCredentialsException("Invalid username or password");
    }
    sessionService.create(username);
    return this.generateJwtToken(user);
  }

  /**
   * GENERATE JWT TOKEN
   */
  @Override
  public String generateJwtToken(User user) throws Exception {
    Claims claims = Jwts.claims().setSubject(user.getUsername());
    claims.put("sessionId", Credential.getSessionId());
    return Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS512, this.jwtSecretKey)
        .compact();
  }

  /**
   * PARSE JWT TOKEN
   */
  @Override
  public Claims parseJwtToken(String jwtToken) {
    try {
      return Jwts.parser().setSigningKey(this.jwtSecretKey).parseClaimsJws(jwtToken).getBody();
    } catch (JwtException | ClassCastException e) {
      return null;
    }
  }

  /**
   * UNAUTHENTICATE
   */
  @Override
  @Transactional(readOnly = false, rollbackFor = Exception.class)
  public void unauthenticate() throws Exception {
    this.sessionService.remove();
  }

  @Override
  @Transactional(readOnly = false, rollbackFor = Exception.class)
  public void changePassword(ChangePasswordDto changePasswordDto) throws Exception {
    String oldPassword = this.generatePassword(changePasswordDto.getOldPassword());
    String newPassword = this.generatePassword(changePasswordDto.getNewPassword());
    User user = userRepository.findByUsernameAndPasswordAndMarkForDeleteFalse(
        changePasswordDto.getUsername(), oldPassword);
    if (user == null) {
      throw new EntityNotFoundException("username and old password not matching.");
    } else {
      user.setPassword(newPassword);
      userRepository.save(user);
    }
  }

}
