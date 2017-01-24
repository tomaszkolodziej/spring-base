package com.tolean.elab.dto.profile;

import lombok.Data;

/**
 * Created by tomasz.kolodziej@poczta.pl
 */
@Data
public class ProfileViewDto {

  private Long id;
  private String login;
  private String name;
  private String firstName;
  private String lastName;
  private String email;
  private boolean active;

}
