package com.nanta.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "N_CONTACT")
@Data
@NoArgsConstructor
public class Contact extends BaseEntity {
  private String name;
  private String email;
  @Column(columnDefinition = "TEXT")
  private String message;
  private String status;
}
