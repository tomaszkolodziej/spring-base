package com.tolean.elab.business.api.profile;

import com.tolean.elab.dto.profile.ProfileNewDto;
import com.tolean.elab.dto.profile.ProfileViewDto;

import java.util.List;

/**
 * Created by Tomasz Kołodziej
 */
public interface ProfileService {

    List<ProfileViewDto> getProfiles();

    ProfileViewDto getProfile(Long id);

    ProfileViewDto getProfile(String login);

    ProfileViewDto add(ProfileNewDto profileNewDto);

}
