package com.tolean.elab.presentation.rest;

import com.tolean.elab.dto.system.SystemInfoViewDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Tomasz Kołodziej
 */
@RestController
@RequestMapping("/system")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SystemRestController {

    private final SystemInfoViewDto systemInfoViewDto;

    @RequestMapping(method = RequestMethod.GET)
    public SystemInfoViewDto getInfo() {
        return systemInfoViewDto;
    }

}
