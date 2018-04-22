package com.nanta.dto;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ReplyMessageDto implements Serializable{
  private String id;
  private String email;
  private String subject;
  private String message;
}
