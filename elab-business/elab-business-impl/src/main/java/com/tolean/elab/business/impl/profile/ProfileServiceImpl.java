package com.tolean.elab.business.impl.profile;

import com.tolean.elab.business.api.profile.ProfileService;
import com.tolean.elab.business.impl.profile.validator.ProfileValidator;
import com.tolean.elab.dto.profile.PasswordNewDto;
import com.tolean.elab.dto.profile.ProfileNewDto;
import com.tolean.elab.dto.profile.ProfileUpdateDto;
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

    @Override
    public ProfileViewDto add(ProfileNewDto profileNewDto) {
        checkNotNull("20170125:0858", profileNewDto);

        Profile profile = profileMapper.toProfile(profileNewDto);
        profileValidator.check(profile);

        profile = profileRepository.save(profile);

        return profileMapper.toProfileViewDto(profile);
    }

    @Override
    public ProfileViewDto update(ProfileUpdateDto profileUpdateDto) {
        checkNotNull("20170126:1856", profileUpdateDto);

        Profile profile = profileRepository.findOne(profileUpdateDto.getId())
                .orElseThrow(() -> new ProfileNotFoundException("20170126:1857", profileUpdateDto.getId()));
        profile.setName(profileUpdateDto.getName());
        profile.setFirstName(profileUpdateDto.getFirstName());
        profile.setLastName(profileUpdateDto.getLastName());
        profile.setEmail(profileUpdateDto.getEmail());

        profileValidator.check(profile);

        profile = profileRepository.save(profile);
        return profileMapper.toProfileViewDto(profile);
    }

    @Override
    public void changePassword(Long profileId, PasswordNewDto passwordNewDto) {
        checkNotNull("20170126:1838", profileId);
        checkNotNull("20170126:1833", passwordNewDto);

        profileValidator.checkPassword(passwordNewDto);

        Profile profile = profileRepository.findOne(profileId).orElseThrow(() -> new ProfileNotFoundException("20170126:1839", profileId));
        // TODO szyfrowanie hasla
        String encodedPassword = passwordNewDto.getNewPassword();
        profile.setPassword(encodedPassword);

        profileRepository.save(profile);
    }

}
