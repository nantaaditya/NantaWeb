package com.nanta.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="N_USER")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity {
  private String username;
  private String password;
}
