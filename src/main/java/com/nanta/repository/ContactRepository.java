package com.nanta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nanta.entity.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, String>{

}
