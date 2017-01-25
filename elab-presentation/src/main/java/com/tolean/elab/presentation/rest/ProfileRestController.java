package com.tolean.elab.presentation.rest;

import com.tolean.elab.business.api.profile.ProfileService;
import com.tolean.elab.dto.profile.ProfileNewDto;
import com.tolean.elab.dto.profile.ProfileViewDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Tomasz Kołodziej
 */
@RestController
@RequestMapping("/profile")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProfileRestController {

    private final ProfileService profileService;

    @RequestMapping(method = RequestMethod.GET)
    public List<ProfileViewDto> getProfiles() {
        return profileService.getProfiles();
    }

    @RequestMapping(value = "/{profileId}", method = RequestMethod.GET)
    public ProfileViewDto getProfile(@PathVariable Long profileId) {
        return profileService.getProfile(profileId);
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ProfileViewDto getProfile(@RequestParam String login) {
        return profileService.getProfile(login);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ProfileViewDto add(@RequestBody ProfileNewDto profileNewDto) {
        return profileService.add(profileNewDto);
    }

}
