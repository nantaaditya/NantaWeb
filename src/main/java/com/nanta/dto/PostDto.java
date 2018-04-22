package com.nanta.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostDto {
  private String id;
  private String title;
  private String image;
  private String post;
  private String url;
  private String createdBy;
  private Date createdDate;
  private String description;
  private String keywords;
  private boolean status;

}
