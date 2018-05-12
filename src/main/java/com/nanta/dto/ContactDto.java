package com.nanta.dto;

import java.io.Serializable;

import com.nanta.base.RegexType;
import com.nanta.validator.Regex;
import com.nanta.validator.Required;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ContactDto implements Serializable {
  private String id;
  @Required(message = "field name is required")
  private String name;
  @Required(message = "field email is required")
  @Regex(type = RegexType.EMAIL, message = "enter valid email address")
  private String email;
  @Required(message = "field message is required")
  private String message;
  private String status;
}
