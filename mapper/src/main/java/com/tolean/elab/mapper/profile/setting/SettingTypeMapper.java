package com.tolean.elab.mapper.profile.setting;

import com.tolean.elab.mapper.EnumMapper;
import com.tolean.elab.persistence.profile.setting.SettingType;
import org.springframework.stereotype.Component;

/**
 * Created by Tomasz Kołodziej
 */
@Component
public class SettingTypeMapper implements EnumMapper<SettingType> {

    @Override
    public String toString(SettingType settingType) {
        return settingType.getName();
    }

    @Override
    public SettingType toEnum(String name) {
        return SettingType.getByName(name);
    }

}
