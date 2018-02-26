package com.nanta.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "N_PAGE")
public class Page extends BaseEntity {
  private String url;
  private long counter;
  @Column(columnDefinition = "TEXT")
  private String description;
  @Column(columnDefinition = "TEXT")
  private String keywords;
  private String robots;
  private boolean status;

  public Page() {}

  public Page(String url, long counter, String description, String keyword, String robots,
      boolean status) {
    this.url = url;
    this.counter = counter;
    this.description = description;
    this.keywords = keyword;
    this.robots = robots;
    this.status = status;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public long getCounter() {
    return counter;
  }

  public void setCounter(long counter) {
    this.counter = counter;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getKeywords() {
    return keywords;
  }

  public void setKeywords(String keywords) {
    this.keywords = keywords;
  }

  public String getRobots() {
    return robots;
  }

  public void setRobots(String robots) {
    this.robots = robots;
  }

  public boolean isStatus() {
    return status;
  }

  public void setStatus(boolean status) {
    this.status = status;
  }  

}
