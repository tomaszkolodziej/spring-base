package com.tolean.elab.mapper.profile.setting;

import com.google.common.collect.Maps;
import com.tolean.elab.dto.profile.setting.SettingViewDto;
import com.tolean.elab.persistence.profile.setting.Setting;
import com.tolean.elab.persistence.profile.setting.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Set;

import static pl.wavesoftware.eid.utils.EidPreconditions.checkNotNull;

/**
 * Created by Tomasz Kołodziej
 */
@Component
public class SettingMapper {

    private final SettingTypeMapper settingTypeMapper;

    @Autowired
    public SettingMapper(SettingTypeMapper settingTypeMapper) {
        this.settingTypeMapper = settingTypeMapper;
    }

    public Map<String, SettingViewDto> toSettingViewDtoMap(Set<Setting> settings) {
        Map<String, SettingViewDto> settingViewDtoMap = Maps.newHashMap();
        settings.forEach(setting -> settingViewDtoMap.put(settingTypeMapper.toString(setting.getType()), toSettingViewDto(setting)));
        return settingViewDtoMap;
    }

    public SettingViewDto toSettingViewDto(Setting setting) {
        checkNotNull(setting, "20170212:191300");

        Parameter parameter = setting.getParameter();

        return SettingViewDto.builder()
                .name(parameter.getName())
                .description(parameter.getDescription())
                .groupName(parameter.getGroup().getName())
                .value(parameter.getValue())
                .availableValues(parameter.getAvailableValues())
                .build();
    }

}
