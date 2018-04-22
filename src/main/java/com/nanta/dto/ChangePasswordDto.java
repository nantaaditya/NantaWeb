package com.nanta.dto;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ChangePasswordDto implements Serializable{
  private String username;
  private String oldPassword;
  private String newPassword;

}
