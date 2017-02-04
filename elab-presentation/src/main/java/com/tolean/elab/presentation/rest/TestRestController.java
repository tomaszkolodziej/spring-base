package com.tolean.elab.presentation.rest;

import com.tolean.elab.dto.profile.ProfileViewDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.wavesoftware.eid.exceptions.EidRuntimeException;

/**
 * Created by Tomasz Kołodziej
 */
@Slf4j
@RestController
@RequestMapping("/test")
public class TestRestController {

    @RequestMapping(value = "/testReturnString", method = RequestMethod.GET)
    public String testReturnString() {
        return "hello world";
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public ProfileViewDto test() {
        log.info("test method called");
        ProfileViewDto profileViewDto = new ProfileViewDto();
        profileViewDto.setId(1L);
        profileViewDto.setLogin("jkowalski");
        profileViewDto.setName("Jan Kowalski");
        profileViewDto.setFirstName("Jan");
        profileViewDto.setLastName("Kowalski");
        profileViewDto.setEmail("jankowalski@wp.pl");
        profileViewDto.setActive(true);
        return profileViewDto;
    }

    @RequestMapping(value = "/testThrowException", method = RequestMethod.GET)
    public void testThrowException() {
        log.info("testThrowException method called");
        new EidRuntimeException("20161105:1409", "message");
    }

}
