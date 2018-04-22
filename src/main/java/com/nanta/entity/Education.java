package com.nanta.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="N_EDUCATION")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Education extends BaseEntity {
  private String name;
  private String year;
  private String description;
}
