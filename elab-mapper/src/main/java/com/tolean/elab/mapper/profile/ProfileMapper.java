package com.tolean.elab.mapper.profile;

import com.tolean.elab.dto.profile.ProfileLightViewDto;
import com.tolean.elab.dto.profile.ProfileNewDto;
import com.tolean.elab.dto.profile.ProfileUpdateDto;
import com.tolean.elab.dto.profile.ProfileViewDto;
import com.tolean.elab.mapper.profile.settings.SettingMapper;
import com.tolean.elab.persistence.profile.Profile;
import com.tolean.elab.persistence.profile.setting.Setting;
import com.tolean.elab.persistence.profile.setting.SettingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by Tomasz Kołodziej
 */
@Component
public class ProfileMapper {

    private final SettingRepository settingRepository;
    private final SimpleProfileMapper simpleProfileMapper;
    private final SettingMapper settingMapper;

    @Autowired
    public ProfileMapper(SettingRepository settingRepository, SimpleProfileMapper simpleProfileMapper, SettingMapper settingMapper) {
        this.settingRepository = settingRepository;
        this.simpleProfileMapper = simpleProfileMapper;
        this.settingMapper = settingMapper;
    }

    public ProfileViewDto toProfileViewDto(Profile profile) {
        ProfileViewDto profileViewDto = simpleProfileMapper.toProfileViewDto(profile);

        Set<Setting> settings = settingRepository.findAll(profile.getId());
        profileViewDto.setSettings(settingMapper.toSettingViewDtos(settings));

        return profileViewDto;
    }

    public Set<ProfileLightViewDto> toProfileLightViewDtos(Set<Profile> profiles) {
        return profiles.stream().map(profile -> toProfileLightViewDto(profile)).collect(Collectors.toSet());
    }

    public ProfileLightViewDto toProfileLightViewDto(Profile profile) {
        return simpleProfileMapper.toProfileLightViewDto(profile);
    }

    public Profile toProfile(ProfileNewDto profileNewDto) {
        return simpleProfileMapper.toProfile(profileNewDto);
    }

    public void intoProfile(Profile profile, ProfileUpdateDto profileUpdateDto) {
        simpleProfileMapper.intoProfile(profile, profileUpdateDto);
    }

}
