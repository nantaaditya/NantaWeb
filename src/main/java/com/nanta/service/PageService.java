package com.nanta.service;

import com.nanta.dto.XmlUrlSet;
import com.nanta.entity.Page;

public interface PageService {
  void save(Page page) throws Exception;

  void accessPage(String url) throws Exception;

  Page findByUrl(String url) throws Exception;

  XmlUrlSet generateSitemap() throws Exception;

}
