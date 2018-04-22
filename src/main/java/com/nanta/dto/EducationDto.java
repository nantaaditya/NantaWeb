package com.nanta.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EducationDto {
  private String id;
  private String name;
  private String year;
  private String description;
}
