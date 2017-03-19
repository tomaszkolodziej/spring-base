package com.tolean.elab.dto.profile;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Tomasz Kołodziej <tomasz.kolodziej@coi.gov.pl>
 */
@Data
@NoArgsConstructor
public class AbstractProfileViewDto {

  private Long id;
  private String login;
  private String name;
  private String firstName;
  private String lastName;
  private String email;
  private boolean active;

}
