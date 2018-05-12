package com.nanta.dto;

import java.io.Serializable;

import com.nanta.validator.InRange;
import com.nanta.validator.Required;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SkillDto implements Serializable {
  private String id;
  @Required(message = "field name is required")
  private String name;
  @InRange(min = 0, max = 100, message = "percentage must be between 0-100")
  private double percentage;
}
