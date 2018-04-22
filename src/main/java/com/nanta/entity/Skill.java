package com.nanta.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "N_SKILL")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Skill extends BaseEntity {
  private String name;
  private double percentage;
}
