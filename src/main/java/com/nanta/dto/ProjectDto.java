package com.nanta.dto;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProjectDto implements Serializable{
  private String id;
  private String image;
  private String name;
  private String site;
}
