package com.nanta.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "N_PROJECT")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Project extends BaseEntity {
  private String image;
  private String name;
  private String site;
}
