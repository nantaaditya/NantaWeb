package com.nanta.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "N_SKILL")
public class Skill extends BaseEntity {
  private String name;
  private double percentage;

  public Skill() {}

  public Skill(String name, double percentage) {
    this.name = name;
    this.percentage = percentage;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getPercentage() {
    return percentage;
  }

  public void setPercentage(double percentage) {
    this.percentage = percentage;
  }

}
