package com.tolean.elab.business.api.profile;

import com.tolean.elab.dto.profile.*;

import java.util.Set;

/**
 * Created by Tomasz Kołodziej
 */
public interface ProfileService {

    Set<ProfileLightViewDto> getProfiles();

    ProfileViewDto getProfile(Long id);

    ProfileViewDto getProfile(String login);

    ProfileViewDto add(ProfileNewDto profileNewDto);

    ProfileViewDto update(Long profileId, ProfileUpdateDto profileUpdateDto);

    void changePassword(Long profileId, PasswordNewDto passwordNewDto);

}
