package com.tolean.elab.business.api.profile;

import com.tolean.elab.dto.profile.PasswordNewDto;
import com.tolean.elab.dto.profile.ProfileNewDto;
import com.tolean.elab.dto.profile.ProfileUpdateDto;
import com.tolean.elab.dto.profile.ProfileViewDto;
import com.tolean.elab.dto.profile.settings.SettingViewDto;

import java.util.List;
import java.util.Set;

/**
 * Created by Tomasz Kołodziej
 */
public interface ProfileService {

    List<ProfileViewDto> getProfiles();

    ProfileViewDto getProfile(Long id);

    ProfileViewDto getProfile(String login);

    ProfileViewDto add(ProfileNewDto profileNewDto);

    ProfileViewDto update(Long profileId, ProfileUpdateDto profileUpdateDto);

    void changePassword(Long profileId, PasswordNewDto passwordNewDto);

    Set<SettingViewDto> getSettings(Long profileId);

    SettingViewDto getSetting(Long profileId, String code);

}
