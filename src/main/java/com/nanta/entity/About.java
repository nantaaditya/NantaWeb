package com.nanta.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "N_ABOUT")
@Data
@NoArgsConstructor
public class About extends BaseEntity {
  @Column(columnDefinition = "TEXT")
  private String description;

}
