package com.tolean.elab.dto.profile;

import com.tolean.elab.dto.profile.setting.SettingViewDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * Created by tomasz.kolodziej@poczta.pl
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProfileViewDto extends AbstractProfileViewDto {

    private Map<String, SettingViewDto> settings;

}
