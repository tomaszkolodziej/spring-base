package com.tolean.elab.mapper.profile.setting;

import com.tolean.elab.dto.profile.setting.SettingViewDto;
import com.tolean.elab.persistence.profile.setting.Setting;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by Tomasz Kołodziej
 */
@Component
public class SettingMapper {

    public Set<SettingViewDto> toSettingViewDtoSet(Set<Setting> settings) {
        checkNotNull("20170128:2010", settings);

        return settings
                .stream()
                .map(setting -> toSettingViewDto(setting))
                .collect(Collectors.toSet());
    }

    public SettingViewDto toSettingViewDto(Setting setting) {
        checkNotNull("20170128:2023", setting);

        SettingViewDto settingViewDto = new SettingViewDto();
        settingViewDto.setCode(setting.getCode());

        boolean valueIsListType = setting.getValueType().isList();
        settingViewDto.setList(valueIsListType);

        if (valueIsListType) {
            // TODO: dokonczyc implementacje parametrow ktore sa listami
        } else {
            settingViewDto.setValue(setting.getValue());
        }

        return settingViewDto;
    }

}
