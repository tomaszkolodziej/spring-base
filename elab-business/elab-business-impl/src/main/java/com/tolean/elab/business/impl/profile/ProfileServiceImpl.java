package com.tolean.elab.business.impl.profile;

import com.tolean.elab.business.api.profile.ProfileService;
import com.tolean.elab.business.impl.profile.action.ProfileChangePasswordAction;
import com.tolean.elab.business.impl.profile.settings.SettingService;
import com.tolean.elab.dto.profile.*;
import com.tolean.elab.mapper.profile.ProfileMapper;
import com.tolean.elab.mapper.profile.settings.SettingMapper;
import com.tolean.elab.persistence.profile.Profile;
import com.tolean.elab.persistence.profile.ProfileDetail;
import com.tolean.elab.persistence.profile.ProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by Tomasz Kołodziej
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProfileServiceImpl implements UserDetailsService, ProfileService {

    private final SettingService settingService;
    private final ProfileRepository profileRepository;
    private final ProfileChangePasswordAction profileChangePasswordAction;
    private final ProfileMapper profileMapper;
    private final SettingMapper settingMapper;
    private final ProfileValidator profileValidator;

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

    public Set<ProfileLightViewDto> getProfiles() {
        return profileMapper.toProfileLightViewDtos(profileRepository.findAll());
    }

    public ProfileViewDto getProfile(Long id) {
        checkNotNull("20170114:115800", id);

        Profile profile = profileRepository.findOne(id).orElseThrow(() -> new ProfileNotFoundException("20140114:121500", id));
        return profileMapper.toProfileViewDto(profile);
    }

    @Override
    public ProfileViewDto getProfile(String login) {
        checkNotNull("20170115:093900", login);

        Profile profile = profileRepository.findByLogin(login).orElseThrow(() -> new ProfileNotFoundException("20170115:094000", login));
        return profileMapper.toProfileViewDto(profile);
    }

    @Override
    public ProfileViewDto add(ProfileNewDto profileNewDto) {
        checkNotNull("20170125:085800", profileNewDto);

        profileValidator.checkNew(profileNewDto);

        Profile profile = profileMapper.toProfile(profileNewDto);
        profile = profileRepository.save(profile);

        return profileMapper.toProfileViewDto(profile);
    }

    @Override
    public ProfileViewDto update(Long profileId, ProfileUpdateDto profileUpdateDto) {
        checkNotNull("20170126:185638", profileUpdateDto);

        profileValidator.checkUpdate(profileUpdateDto);

        Profile profile = profileRepository.findOne(profileId).orElseThrow(() -> new ProfileNotFoundException("20170126:185700", profileId));
        profileMapper.intoProfile(profile, profileUpdateDto);
        profile = profileRepository.save(profile);

        return profileMapper.toProfileViewDto(profile);
    }

    @Override
    public void changePassword(Long profileId, PasswordNewDto passwordNewDto) {
        checkNotNull("20170126:183800", profileId);
        checkNotNull("20170126:183301", passwordNewDto);

        Profile profile = profileRepository.findOne(profileId).orElseThrow(() -> new ProfileNotFoundException("20170126:183900", profileId));
        profile = profileChangePasswordAction.change(profile, passwordNewDto);

        profileRepository.save(profile);
    }

}
