package com.tolean.elab.dto.profile;

import com.tolean.elab.dto.profile.setting.SettingViewDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

/**
 * Created by tomasz.kolodziej@poczta.pl
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProfileViewDto {

    private Long id;
    private String login;
    private String name;
    private String firstName;
    private String lastName;
    private String email;
    private boolean active;
    private Set<SettingViewDto> settings;

}
