package com.nanta.service.implementation;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.nanta.base.CacheTopics;
import com.nanta.converter.BlogConverter;
import com.nanta.converter.PostConverter;
import com.nanta.dto.BlogDto;
import com.nanta.dto.PostDto;
import com.nanta.entity.Blog;
import com.nanta.entity.Page;
import com.nanta.repository.BlogRepository;
import com.nanta.repository.PageRepository;
import com.nanta.service.BlogService;
import com.nanta.service.FileService;
import com.nanta.service.PageService;
import com.nanta.validator.Validator;

import lombok.extern.slf4j.Slf4j;

@Service
@Transactional(readOnly = true)
@Slf4j
public class BlogServiceImplementation implements BlogService {
  @Autowired
  private BlogRepository blogRepository;
  @Autowired
  private FileService fileService;
  @Autowired
  private PageService pageService;
  @Autowired
  private PageRepository pageRepository;

  private String BASE_URL = "http://www.nantaaditya.com";
  private static final String CREATOR = "Nanta";
  private static final String BLOG_FILE_PATH = "/post/";
  private static final String BLOG_PATH = "/blog/";
  private static final String ROBOTS = "index, follow";
  private static final long COUNTER = 0;
  private final String BLOG_URL = this.BASE_URL + BLOG_PATH;

  private PostDto onSave(PostDto postDto) {
    postDto.setCreatedBy(CREATOR);
    postDto.setCreatedDate(new Date());
    postDto.setUrl(generateTitleUrl(postDto.getTitle()));
    postDto.setTitle(StringUtils.capitalize(postDto.getTitle()));
    return postDto;
  }

  private String generateTitleUrl(String url) {
    return url.replace(" ", "-");
  }

  private String generateImagePath(String imageName) {
    return "/resource/post/" + imageName + ".jpg";
  }

  private String generateUri(String uri) {
    log.info(BLOG_URL + uri);
    return BLOG_URL + uri;
  }

  @Override
  @Transactional(readOnly = false, rollbackFor = Exception.class)
  @Cacheable(value = CacheTopics.BLOG)
  public void save(MultipartFile file, PostDto postDto) throws Exception {
    postDto = onSave(postDto);

    if (Validator.isAvailable(this.blogRepository.findByUrl(postDto.getUrl()))) {
      throw new EntityExistsException("url already used");
    } else {
      this.fileService.uploadFile(file, BLOG_FILE_PATH, postDto.getUrl());
      postDto.setImage(generateImagePath(postDto.getUrl()));
      Page page = Page.builder().url(generateUri(postDto.getUrl())).counter(COUNTER)
          .description(postDto.getDescription()).keywords(postDto.getKeywords()).robots(ROBOTS)
          .status(true).build();

      this.blogRepository.save(PostConverter.toEntity(postDto));
      this.pageService.save(page);
    }
  }

  @Override
  @Transactional(readOnly = false, rollbackFor = Exception.class)
  @CachePut(value = CacheTopics.BLOG)
  public void update(PostDto postDto) throws Exception {
    Blog blog = this.blogRepository.findOne(postDto.getId());
    blog.setPost(postDto.getPost());
    this.blogRepository.save(this.blogRepository.findOne(postDto.getId()));
  }

  @Override
  @Transactional(readOnly = false, rollbackFor = Exception.class)
  @CachePut(value = CacheTopics.BLOG)
  public void toggle(String id, boolean status) throws Exception {
    Blog blog = this.blogRepository.findOne(id);
    blog.setStatus(status);
    this.blogRepository.save(blog);
  }

  @Override
  @Transactional(readOnly = false, rollbackFor = Exception.class)
  @CacheEvict(value = CacheTopics.BLOG, allEntries = true)
  public void delete(String id) throws Exception {
    Blog blog = this.blogRepository.findOne(id);
    Page page = this.pageRepository.findByUrl(BLOG_URL + blog.getUrl());
    if (Validator.isAvailable(blog) && Validator.isAvailable(page)) {
      this.fileService.deleteFile(BLOG_FILE_PATH, blog.getUrl() + ".jpg");
      this.blogRepository.delete(id);
      this.pageRepository.delete(page);
    }else {
      throw new EntityNotFoundException("couldn't find data to remove");
    }
  }

  @Override
  public List<BlogDto> findAll() throws Exception {
    return BlogConverter.toDtos(this.blogRepository.findAll());
  }

  @Override
  public PostDto findByUrl(String url) throws Exception {
    Page page = this.pageRepository.findByUrl(BLOG_URL + url);
    PostDto postDto = PostConverter.toDto(this.blogRepository.findByUrlAndStatusTrue(url));
    if (Validator.isAvailable(postDto) && Validator.isAvailable(page)) {
      postDto.setDescription(page.getDescription());
      postDto.setKeywords(page.getKeywords());
    }
    return postDto;
  }

  @Override
  @Cacheable(value = CacheTopics.BLOG, condition = "#result != null")
  public List<BlogDto> findAllActive() throws Exception {
    return BlogConverter.toDtos(this.blogRepository.findByStatusTrue());
  }

}
