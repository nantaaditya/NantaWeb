package com.nanta.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

@Entity
@Table(name = "N_BLOG",
    indexes = {@Index(name = "title_index", columnList = "title", unique = true)})
public class Blog extends BaseEntity {
  private String title;
  private String image;
  @Column(columnDefinition = "TEXT")
  private String post;
  private String url;  
  private boolean status;

  public Blog() {}

  public Blog(String title, String image, String post, String url, boolean status) {
    this.title = title;
    this.image = image;
    this.post = post;
    this.url = url;
    this.status = status;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public String getPost() {
    return post;
  }

  public void setPost(String post) {
    this.post = post;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public boolean isStatus() {
    return status;
  }

  public void setStatus(boolean status) {
    this.status = status;
  }
}
