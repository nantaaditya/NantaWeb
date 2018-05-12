package com.nanta.dto;

import java.io.Serializable;

import com.nanta.validator.Required;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ReplyMessageDto implements Serializable {
  @Required(message = "field id is required")
  private String id;
  @Required(message = "field email is required")
  private String email;
  @Required(message = "field subject is required")
  private String subject;
  @Required(message = "field message is required")
  private String message;
}
