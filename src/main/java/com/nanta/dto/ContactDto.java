package com.nanta.dto;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ContactDto implements Serializable{
  private String id;
  private String name;
  private String email;
  private String message;
  private String status;
}
