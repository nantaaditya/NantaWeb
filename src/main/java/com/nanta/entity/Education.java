package com.nanta.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="N_EDUCATION")
public class Education extends BaseEntity {
  private String name;
  private String year;
  private String description;

  public Education() {}

  public Education(String name, String year, String description) {
    this.name = name;
    this.year = year;
    this.description = description;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getYear() {
    return year;
  }

  public void setYear(String year) {
    this.year = year;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

}
