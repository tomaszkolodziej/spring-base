package com.tolean.elab.mapper.profile;

import com.tolean.elab.dto.profile.ProfileNewDto;
import com.tolean.elab.dto.profile.ProfileViewDto;
import com.tolean.elab.mapper.profile.setting.SettingMapper;
import com.tolean.elab.persistence.profile.Profile;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

/**
 * Created by Tomasz Kołodziej
 */
@Mapper(uses = SettingMapper.class)
public interface ProfileMapper {

    ProfileViewDto toProfileViewDto(Profile profile);

    List<ProfileViewDto> toProfileViewDtoList(List<Profile> profileList);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createDate", ignore = true)
    @Mapping(target = "createBy", ignore = true)
    @Mapping(target = "updateDate", ignore = true)
    @Mapping(target = "updateBy", ignore = true)
    @Mapping(target = "password", ignore = true)
    @Mapping(target = "active", ignore = true)
    @Mapping(target = "settings", ignore = true)
    Profile toProfile(ProfileNewDto profileNewDto);

}
