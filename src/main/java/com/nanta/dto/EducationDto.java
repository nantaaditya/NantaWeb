package com.nanta.dto;

import com.nanta.validator.Required;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EducationDto {
  private String id;
  @Required(message = "field name is required")
  private String name;
  @Required(message = "field year is required")
  private String year;
  private String description;
}
