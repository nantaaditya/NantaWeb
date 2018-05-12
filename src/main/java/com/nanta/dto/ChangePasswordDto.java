package com.nanta.dto;

import java.io.Serializable;

import com.nanta.validator.Required;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ChangePasswordDto implements Serializable {
  @Required(message = "field username is required")
  private String username;
  @Required(message = "field old password is required")
  private String oldPassword;
  @Required(message = "field new password is required")
  private String newPassword;

}
