package com.nanta.dto;

import java.io.Serializable;

import com.nanta.validator.Required;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AboutDto implements Serializable {
  @Required(message = "field description is required")
  private String description;
}
