package com.nanta.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "N_ABOUT")
public class About extends BaseEntity {
  @Column(columnDefinition="TEXT")
  private String description;

  public About() {}

  public About(String description) {
    this.description = description;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

}
