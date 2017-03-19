package com.tolean.elab.mapper.profile;

import com.tolean.elab.dto.profile.ProfileLightViewDto;
import com.tolean.elab.dto.profile.ProfileNewDto;
import com.tolean.elab.dto.profile.ProfileUpdateDto;
import com.tolean.elab.dto.profile.ProfileViewDto;
import com.tolean.elab.persistence.profile.Profile;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

/**
 * Created by Tomasz Kołodziej
 */
@Mapper
public interface SimpleProfileMapper {

    @Mapping(target = "settings", ignore = true)
    ProfileViewDto toProfileViewDto(Profile profile);

    ProfileLightViewDto toProfileLightViewDto(Profile profile);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createDate", ignore = true)
    @Mapping(target = "createBy", ignore = true)
    @Mapping(target = "updateDate", ignore = true)
    @Mapping(target = "updateBy", ignore = true)
    @Mapping(target = "password", ignore = true)
    @Mapping(target = "active", ignore = true)
    Profile toProfile(ProfileNewDto profileNewDto);

    void intoProfile(Profile profile, @MappingTarget ProfileUpdateDto profileUpdateDto);

}
