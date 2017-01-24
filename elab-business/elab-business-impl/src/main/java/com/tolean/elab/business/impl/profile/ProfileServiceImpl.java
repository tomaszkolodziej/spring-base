package com.tolean.elab.business.impl.profile;

import com.tolean.elab.business.api.profile.ProfileService;
import com.tolean.elab.dto.profile.ProfileViewDto;
import com.tolean.elab.mapper.profile.ProfileMapper;
import com.tolean.elab.persistence.profile.Profile;
import com.tolean.elab.persistence.profile.ProfileDetail;
import com.tolean.elab.persistence.profile.ProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by Tomasz Kołodziej
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProfileServiceImpl implements UserDetailsService, ProfileService {

    private final ProfileRepository profileRepository;
    private final ProfileMapper profileMapper;

    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Optional<Profile> profileOptional = profileRepository.findByLogin(login);

        if (profileOptional.isPresent()) {
            final Profile profile = profileOptional.get();
            return new ProfileDetail(profile);
        } else {
            // todo [tomek] akcja w przypadku, gdy nie ma takiego loginu
            throw new RuntimeException("Brak loginu " + login);
        }
    }

    public List<ProfileViewDto> getProfiles() {
      return profileMapper.toProfileViewDtoList(profileRepository.findAll());
    }

  public ProfileViewDto getProfile(Long id) {
    checkNotNull("20170114:1158", id);

    Profile profile = profileRepository.findOne(id)
      .orElseThrow(() -> new ProfileNotFoundException("20140114:1215", id));

    return profileMapper.toProfileViewDto(profile);
  }

  @Override
  public ProfileViewDto getProfile(String login) {
    checkNotNull("20170115:0939", login);

    Profile profile = profileRepository.findByLogin(login)
      .orElseThrow(() -> new ProfileNotFoundException("20170115:0940", login));

    return profileMapper.toProfileViewDto(profile);
  }

}
