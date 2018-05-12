package com.nanta.dto;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PictureDto implements Serializable {
  private String id;  
  private String image; 
  private String title;
  private boolean status;
}
