package com.tolean.elab.dto.profile;

import lombok.Data;

/**
 * Created by Tomasz Kołodziej
 */
@Data
public class PasswordNewDto {

    private String oldPassword;
    private String newPassword;
    private String repeatedNewPassword;

}
