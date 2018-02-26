package com.nanta.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.nanta.dto.XmlUrlSet;
import com.nanta.service.PageService;

@RestController
public class SitemapController {
  @Autowired
  private PageService pageService;

  @RequestMapping(value = "/sitemap.xml", method = RequestMethod.GET)
  public @ResponseBody XmlUrlSet sitemap() throws Exception {
    return pageService.generateSitemap();
  }
}
