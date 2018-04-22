package com.nanta.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "N_PAGE")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Page extends BaseEntity {
  private String url;
  private long counter;
  @Column(columnDefinition = "TEXT")
  private String description;
  @Column(columnDefinition = "TEXT")
  private String keywords;
  private String robots;
  private boolean status;
}
