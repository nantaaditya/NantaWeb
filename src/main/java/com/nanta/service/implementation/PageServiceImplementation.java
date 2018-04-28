package com.nanta.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nanta.dto.XmlUrl;
import com.nanta.dto.XmlUrlSet;
import com.nanta.entity.Page;
import com.nanta.repository.PageRepository;
import com.nanta.service.PageService;
import com.nanta.validator.Validator;

@Service
@Transactional(readOnly = true)
public class PageServiceImplementation implements PageService {
  @Autowired
  private PageRepository pageRepository;

  private long incrementPageCounter(long counter) {
    return ++counter;
  }

  @Override
  @Transactional(readOnly = false, rollbackFor = Exception.class)
  public void save(Page page) throws Exception {
    this.pageRepository.save(page);
  }

  @Override
  @Transactional(readOnly = false, rollbackFor = Exception.class)  
  public void accessPage(String url) throws Exception {
    Page page = this.pageRepository.findByUrl(url);
    if (Validator.isAvailable(page)) {
      page.setCounter(incrementPageCounter(page.getCounter()));
    }
    this.pageRepository.save(page);
  }

  @Override
  public Page findByUrl(String url) throws Exception {
    return this.pageRepository.findByUrl(url);
  }

  @Override
  public XmlUrlSet generateSitemap() throws Exception {
    XmlUrlSet xmlUrlSet = new XmlUrlSet();
    for (Page page : this.pageRepository.findAll()) {
      xmlUrlSet.addUrl(new XmlUrl(page.getUrl(), XmlUrl.Priority.HIGH));
    }
    return xmlUrlSet;
  }

}
