package com.tolean.elab.presentation.rest;

import com.tolean.elab.business.api.diagnosis.DiagnosisService;
import com.tolean.elab.dto.profile.ProfileViewDto;
import com.tolean.elab.tools.AppException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Tomasz Kołodziej
 */
@Slf4j
@RestController
@RequestMapping("/test")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TestRestController {

    private final DiagnosisService diagnosisService;

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
        new AppException("20161105:140909", "TEST", "message");
    }

    @RequestMapping(value = "/testSendSms", method = RequestMethod.GET)
    public void testSendSms(@RequestParam String mobileNo) {
        diagnosisService.testSendSms(mobileNo);
    }

}
