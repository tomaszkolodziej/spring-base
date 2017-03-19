package com.tolean.elab.presentation.security;

import com.tolean.elab.dto.profile.ProfileViewDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Tomasz Kołodziej
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticationResponse {

    private ProfileViewDto profile;
    private String token;

}
