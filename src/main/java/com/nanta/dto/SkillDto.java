package com.nanta.dto;

public class SkillDto {
  private String id;
  private String name;
  private double percentage;

  public SkillDto() {}

  public SkillDto(String name, double percentage) {
    this.name = name;
    this.percentage = percentage;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
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
