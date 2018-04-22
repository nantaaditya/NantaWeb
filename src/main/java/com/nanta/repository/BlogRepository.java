package com.nanta.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nanta.entity.Blog;

@Repository
public interface BlogRepository extends JpaRepository<Blog, String> {
  Blog findByUrl(String url) throws Exception;

  Blog findByUrlAndStatusTrue(String url) throws Exception;
  
  List<Blog> findByStatusTrue() throws Exception;
}
