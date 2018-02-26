package com.nanta.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "N_PROJECT")
public class Project extends BaseEntity {
  private String image;
  private String name;
  private String site;

  public Project() {}

  public Project(String image, String name, String site) {
    this.image = image;
    this.name = name;
    this.site = site;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSite() {
    return site;
  }

  public void setSite(String site) {
    this.site = site;
  }

}
