package com.nanta.controller.ui;

import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nanta.base.UiPath;
import com.nanta.dto.PostDto;
import com.nanta.entity.Page;
import com.nanta.exception.PageNotFoundException;
import com.nanta.service.BlogService;
import com.nanta.service.PageService;

@Controller
public class PublicController {
  @Autowired
  private PageService pageService;
  @Autowired
  private BlogService blogService;
  private Logger log = Logger.getLogger(this.getClass());
  private SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy");
  private SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");

  @RequestMapping(value = UiPath.HOME, method = RequestMethod.GET)
  public ModelAndView dashboardPage(HttpServletRequest request, ModelAndView model)
      throws Exception {
    log.warn(request.getRequestURL());
    pageService.accessPage(request.getRequestURL().toString());
    Page page = pageService.findByUrl(request.getRequestURL().toString());
    if (page != null) {
      model.addObject("url", page.getUrl());
      model.addObject("description", page.getDescription());
      model.addObject("keywords", page.getKeywords());
      model.addObject("robots", page.getRobots());
    }
    model.setViewName("/home");
    return model;
  }

  @RequestMapping(value = UiPath.GALLERY, method = RequestMethod.GET)
  public ModelAndView galleryPage(HttpServletRequest request, ModelAndView model) throws Exception {
    log.warn(request.getRequestURL());
    pageService.accessPage(request.getRequestURL().toString());
    Page page = pageService.findByUrl(request.getRequestURL().toString());
    if (page != null) {
      model.addObject("url", page.getUrl());
      model.addObject("description", page.getDescription());
      model.addObject("keywords", page.getKeywords());
      model.addObject("robots", page.getRobots());
    }
    model.setViewName("/gallery");
    return model;
  }

  @RequestMapping(value = UiPath.ABOUT, method = RequestMethod.GET)
  public ModelAndView aboutPage(HttpServletRequest request, ModelAndView model) throws Exception {
    log.warn(request.getRequestURL());
    pageService.accessPage(request.getRequestURL().toString());
    Page page = pageService.findByUrl(request.getRequestURL().toString());
    if (page != null) {
      model.addObject("url", page.getUrl());
      model.addObject("description", page.getDescription());
      model.addObject("keywords", page.getKeywords());
      model.addObject("robots", page.getRobots());
    }
    model.setViewName("/about");
    return model;
  }

  @RequestMapping(value = UiPath.BLOG, method = RequestMethod.GET)
  public ModelAndView blogPage(HttpServletRequest request, ModelAndView model) throws Exception {
    log.warn(request.getRequestURL());
    pageService.accessPage(request.getRequestURL().toString());
    Page page = pageService.findByUrl(request.getRequestURL().toString());
    if (page != null) {
      model.addObject("url", page.getUrl());
      model.addObject("description", page.getDescription());
      model.addObject("keywords", page.getKeywords());
      model.addObject("robots", page.getRobots());
    }
    model.setViewName("/blog");
    return model;
  }

  @RequestMapping(value = UiPath.BLOG + "/{url}", method = RequestMethod.GET)
  public ModelAndView postPage(@PathVariable String url, HttpServletRequest request,
      ModelAndView model) throws Exception {
    log.warn(request.getRequestURL());
    pageService.accessPage(request.getRequestURL().toString());
    Page page = pageService.findByUrl(request.getRequestURL().toString());
    PostDto postDto = blogService.findByUrl(url);

    if (page != null) {
      model.addObject("url", page.getUrl());
      model.addObject("description", page.getDescription());
      model.addObject("keywords", page.getKeywords());
      model.addObject("robots", page.getRobots());
    }
    if (postDto != null) {
      model.addObject("createdBy", postDto.getCreatedBy());
      model.addObject("createdDate", dateFormat.format(postDto.getCreatedDate()));
      model.addObject("year", yearFormat.format(postDto.getCreatedDate()));
      model.addObject("image", postDto.getImage());
      model.addObject("post", postDto.getPost());
      model.addObject("title", postDto.getTitle());
    } else {
      throw new PageNotFoundException();
    }
    model.setViewName("/post");
    return model;
  }
}
