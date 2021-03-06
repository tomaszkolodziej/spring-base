package com.tolean.elab.presentation.rest;

import com.tolean.elab.business.api.profile.ProfileService;
import com.tolean.elab.dto.profile.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * Created by Tomasz Kołodziej
 */
@RestController
@RequestMapping("/profile")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProfileRestController {

    private final ProfileService profileService;

    @RequestMapping(method = RequestMethod.GET)
    public Collection<ProfileLightViewDto> getProfiles() {
        return profileService.getProfiles();
    }

    @RequestMapping(method = RequestMethod.POST)
    public ProfileViewDto add(@RequestBody ProfileNewDto profileNewDto) {
        return profileService.add(profileNewDto);
    }

    @RequestMapping(value = "/{profileId}", method = RequestMethod.GET)
    public ProfileViewDto getProfile(@PathVariable Long profileId) {
        return profileService.getProfile(profileId);
    }

    @RequestMapping(value = "/{profileId}", method = RequestMethod.PUT)
    public ProfileViewDto update(@PathVariable Long profileId, @RequestBody ProfileUpdateDto profileUpdateDto) {
        return profileService.update(profileId, profileUpdateDto);
    }

    @RequestMapping(value = "/{profileId}/changePassword", method = RequestMethod.PUT)
    public void changePassword(@PathVariable Long profileId, @RequestBody PasswordNewDto passwordNewDto) {
        profileService.changePassword(profileId, passwordNewDto);
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ProfileViewDto getProfile(@RequestParam String login) {
        return profileService.getProfile(login);
    }

}
