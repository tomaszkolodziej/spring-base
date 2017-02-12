package com.tolean.elab.mapper.profile.settings;

import com.tolean.elab.dto.profile.settings.SettingViewDto;
import com.tolean.elab.persistence.profile.setting.Setting;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

import static pl.wavesoftware.eid.utils.EidPreconditions.checkNotNull;

/**
 * Created by Tomasz Kołodziej
 */
@Component
public class SettingMapper {

    public Set<SettingViewDto> toSettingViewDtos(Set<Setting> settings) {
        checkNotNull(settings, "20170212:191600");

        return settings.stream().map(setting -> toSettingViewDto(setting)).collect(Collectors.toSet());
    }

    public SettingViewDto toSettingViewDto(Setting setting) {
        checkNotNull(setting, "20170212:191300");

        return SettingViewDto.builder()
                .code(setting.getCode())
                .name(setting.getName())
                .description(setting.getDescription())
                .groupName(setting.getGroup().getName())
                .onlyAdministratorCanChange(setting.isOnlyAdministratorCanChange())
                .value(setting.getValue())
                .build();
    }

}
