package com.nanta.dto;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SkillDto implements Serializable{
  private String id;
  private String name;
  private double percentage;
}
