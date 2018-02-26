package com.nanta.service.implementation;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

import javax.xml.bind.annotation.adapters.HexBinaryAdapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nanta.entity.User;
import com.nanta.repository.UserRepository;
import com.nanta.service.UserService;

@Service
@Transactional(readOnly = true)
public class UserServiceImplementation implements UserService {
  @Autowired
  private UserRepository userRepository;

  @Value("${jwt.secret.key}")
  private String jwtSecretKey;

  private String generatePassword(String password) throws Exception {
    MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
    return (new HexBinaryAdapter())
        .marshal(messageDigest.digest(password.getBytes(StandardCharsets.UTF_8)));
  }

  @Override
  @Transactional(readOnly = false, rollbackFor = Exception.class)
  public void save(User user) throws Exception {
    user.setPassword(generatePassword(user.getPassword()));
    userRepository.save(user);
  }
}
