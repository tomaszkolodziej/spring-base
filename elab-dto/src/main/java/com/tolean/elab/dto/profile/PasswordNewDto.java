package com.tolean.elab.dto.profile;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Tomasz Kołodziej
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PasswordNewDto {

    private String oldPassword;
    private String newPassword;
    private String repeatedNewPassword;

}
