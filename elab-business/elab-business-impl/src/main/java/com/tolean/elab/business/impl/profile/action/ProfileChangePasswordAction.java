package com.tolean.elab.business.impl.profile.action;

import com.tolean.elab.business.impl.profile.ProfileValidator;
import com.tolean.elab.dto.profile.PasswordNewDto;
import com.tolean.elab.persistence.profile.Profile;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static pl.wavesoftware.eid.utils.EidPreconditions.checkNotNull;

/**
 * Created by Tomasz Kołodziej
 */
@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProfileChangePasswordAction {

    private final ProfileValidator profileValidator;

    public Profile change(Profile profile, PasswordNewDto passwordNewDto) {
        checkNotNull(profile, "20170202:190602");
        checkNotNull(passwordNewDto, "20170202:190603");

        profileValidator.checkPassword(passwordNewDto);

        // TODO szyfrowanie hasla
        String encodedPassword = passwordNewDto.getNewPassword();
        profile.setPassword(encodedPassword);

        return profile;
    }

}
