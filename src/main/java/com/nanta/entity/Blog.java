package com.nanta.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "N_BLOG",
    indexes = {@Index(name = "title_index", columnList = "title", unique = true)})
@Data
@NoArgsConstructor
public class Blog extends BaseEntity {
  private String title;
  private String image;
  @Column(columnDefinition = "TEXT")
  private String post;
  private String url;  
  private boolean status;
}
