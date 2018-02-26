package com.nanta.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "N_PICTURE")
public class Picture extends BaseEntity {
  private String image;
  private String title;
  private boolean status;

  public Picture() {}

  public Picture(String image, String title, boolean status) {
    this.image = image;
    this.title = title;
    this.status = status;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public boolean isStatus() {
    return status;
  }

  public void setStatus(boolean status) {
    this.status = status;
  }
}
