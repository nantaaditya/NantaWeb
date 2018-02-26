package com.nanta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nanta.entity.Page;

@Repository
public interface PageRepository extends JpaRepository<Page, String>{
  Page findByUrl(String url) throws Exception;
}
