package com.nanta.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.nanta.dto.XmlUrl;
import com.nanta.dto.XmlUrlSet;
import com.nanta.entity.Page;
import com.nanta.repository.PageRepository;
import com.nanta.service.PageService;

@Service
@Transactional(readOnly = true)
public class PageServiceImplementation implements PageService {
  @Autowired
  private PageRepository pageRepository;

  @Override
  @Transactional(readOnly = false, rollbackFor = Exception.class)
  public void save(Page page) throws Exception {
    pageRepository.save(page);
  }

  @Override
  @Transactional(readOnly = false, rollbackFor = Exception.class)
  public void accessPage(String url) throws Exception {
    Page page = pageRepository.findByUrl(url);
    if (page != null) {
      long counter = page.getCounter() + 1;
      page.setCounter(counter);
      pageRepository.save(page);
    }
  }

  @Override
  public Page findByUrl(String url) throws Exception {
    return pageRepository.findByUrl(url);
  }

  @Override
  public XmlUrlSet generateSitemap() throws Exception {
    XmlUrlSet xmlUrlSet = new XmlUrlSet();
    for (Page page : pageRepository.findAll()) {
      xmlUrlSet.addUrl(new XmlUrl(page.getUrl(), XmlUrl.Priority.HIGH));
    }
    return xmlUrlSet;
  }

}
