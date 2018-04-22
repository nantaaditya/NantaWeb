package com.nanta.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = Session.TABLE_NAME,
    uniqueConstraints = {@UniqueConstraint(columnNames = {Session.COLUMN_USERNAME})})
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Session implements Serializable {
  public static final String TABLE_NAME = "N_SESSION";
  public static final String COLUMN_ID = "ID";
  public static final String COLUMN_USERNAME = "USERNAME";
  public static final String COLUMN_SESSION_ID = "SESSION_ID";
  public static final String COLUMN_HOSTNAME = "HOSTNAME";

  @Id
  @Column(name = Session.COLUMN_ID)
  @GeneratedValue(generator = "system-uuid")
  @GenericGenerator(name = "system-uuid", strategy = "uuid2")
  @org.springframework.data.annotation.Id
  private String id;

  @Column(name = Session.COLUMN_USERNAME, nullable = false)
  private String username;

  @Column(name = Session.COLUMN_SESSION_ID, nullable = false)
  private String sessionId;

  @Column(name = Session.COLUMN_HOSTNAME, nullable = false)
  private String hostname;

}
