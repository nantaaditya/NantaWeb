package com.nanta.service.implementation;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityExistsException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.nanta.base.BaseConfiguration;
import com.nanta.converter.BlogConverter;
import com.nanta.converter.PostConverter;
import com.nanta.dto.BlogDto;
import com.nanta.dto.PostDto;
import com.nanta.entity.Blog;
import com.nanta.entity.Page;
import com.nanta.repository.BlogRepository;
import com.nanta.service.BlogService;
import com.nanta.service.FileService;
import com.nanta.service.PageService;
import com.nanta.util.NantaUtils;

@Service
@Transactional(readOnly = true)
public class BlogServiceImplementation implements BlogService {
  @Autowired
  private BlogRepository blogRepository;
  @Autowired
  private FileService fileService;
  @Autowired
  private PageService pageService;

  @Override
  @Transactional(readOnly = false, rollbackFor = Exception.class)
  public void save(MultipartFile file, PostDto postDto) throws Exception {
    postDto.setCreatedBy("Nanta");
    postDto.setCreatedDate(new Date());
    postDto.setUrl(postDto.getTitle().replace(" ", "-"));
    postDto.setTitle(StringUtils.capitalize(postDto.getTitle()));

    if (blogRepository.findByUrl(postDto.getUrl()) != null)
      throw new EntityExistsException("url already used");
    else {
      fileService.uploadFile(file, "/post/", postDto.getUrl());
      postDto.setImage("/resource/post/" + postDto.getUrl() + ".jpg");
      Page page = new Page(BaseConfiguration.BASE_URL + "/blog/" + postDto.getUrl(), 0,
          NantaUtils.html2text(postDto.getPost().substring(0, 275)),
          "Nanta, Nanta Aditya, Nanta Aditya's website, Nanta Aditya's profile, Nanta Aditya's blog, Nanta Aditya's photography",
          "index, follow", true);

      blogRepository.save(PostConverter.toEntity(postDto));
      pageService.save(page);
    }
  }

  @Override
  @Transactional(readOnly = false, rollbackFor = Exception.class)
  public void update(PostDto postDto) throws Exception {
    Blog blog = blogRepository.findOne(postDto.getId());
    blog.setPost(postDto.getPost());
    blogRepository.save(blog);
  }

  @Override
  @Transactional(readOnly = false, rollbackFor = Exception.class)
  public void toggle(String id, boolean status) throws Exception {
    Blog blog = blogRepository.findOne(id);
    blog.setStatus(status);
    blogRepository.save(blog);
  }

  @Override
  @Transactional(readOnly = false, rollbackFor = Exception.class)
  public void delete(String id) throws Exception {
    Blog blog = blogRepository.findOne(id);
    fileService.deleteFile("/post/", blog.getUrl() + ".jpg");
    blogRepository.delete(id);
  }

  @Override
  public List<BlogDto> findAll() throws Exception {
    return BlogConverter.toDtos(blogRepository.findAll());
  }

  @Override
  public PostDto findByUrl(String url) throws Exception {
    return PostConverter.toDto(blogRepository.findByUrl(url));
  }

  @Override
  public List<BlogDto> findAllActive() throws Exception {
    return BlogConverter.toDtos(blogRepository.findByStatusTrue());
  }

}
