package com.tolean.elab.business.impl.profile.action;

import com.tolean.elab.dto.profile.ProfileUpdateDto;
import com.tolean.elab.persistence.profile.Profile;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by Tomasz Kołodziej
 */
@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProfileUpdateAction {

    public Profile update(Profile profile, ProfileUpdateDto profileUpdateDto) {
        checkNotNull("20170202:184901", profile);
        checkNotNull("20170202:185002", profileUpdateDto);

        profile.setName(profileUpdateDto.getName());
        profile.setFirstName(profileUpdateDto.getFirstName());
        profile.setLastName(profileUpdateDto.getLastName());
        profile.setEmail(profileUpdateDto.getEmail());

        return profile;
    }

}
