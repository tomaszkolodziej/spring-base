package com.tolean.elab.mapper.profile;

import com.tolean.elab.dto.profile.ProfileViewDto;
import com.tolean.elab.persistence.profile.Profile;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * Created by tomasz.kolodziej@poczta.pl
 */
@Mapper
public interface ProfileMapper {

  ProfileViewDto toProfileViewDto(Profile profile);

  List<ProfileViewDto> toProfileViewDtoList(List<Profile> profileList);

}
