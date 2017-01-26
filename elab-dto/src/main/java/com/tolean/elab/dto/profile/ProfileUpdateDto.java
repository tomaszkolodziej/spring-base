package com.tolean.elab.dto.profile;

import lombok.Data;

/**
 * Created by Tomasz Kołodziej
 */
@Data
public class ProfileUpdateDto {

    private Long id;
    private String name;
    private String firstName;
    private String lastName;
    private String email;

}
