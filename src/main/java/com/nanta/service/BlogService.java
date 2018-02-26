package com.nanta.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.nanta.dto.BlogDto;
import com.nanta.dto.PostDto;

public interface BlogService {
  void save(MultipartFile file, PostDto postDto) throws Exception;

  void update(PostDto postDto) throws Exception;

  void toggle(String id, boolean status) throws Exception;

  void delete(String id) throws Exception;

  List<BlogDto> findAll() throws Exception;

  List<BlogDto> findAllActive() throws Exception;

  PostDto findByUrl(String url) throws Exception;
}
