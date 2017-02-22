package com.tolean.elab.dto.profile;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by tomasz.kolodziej@poczta.pl
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProfileLightViewDto {

    private Long id;
    private String login;
    private String name;
    private String firstName;
    private String lastName;
    private String email;
    private boolean active;

}
