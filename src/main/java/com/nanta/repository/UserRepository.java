package com.nanta.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nanta.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, String> {
  User findByUsername(String username) throws Exception;

  User findByUsernameAndPasswordAndMarkForDeleteFalse(String username, String digestedPassword);
}
