package com.nanta.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "N_PICTURE")
@Data
@NoArgsConstructor
public class Picture extends BaseEntity {
  private String image;
  private String title;
  private boolean status;
}
