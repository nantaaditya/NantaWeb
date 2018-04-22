package com.nanta.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BlogDto implements Serializable{
  private String id;
  private String title;
  private String image;
  private String url;
  private String createdBy;  
  private Date createdDate;
  private boolean status;
}
