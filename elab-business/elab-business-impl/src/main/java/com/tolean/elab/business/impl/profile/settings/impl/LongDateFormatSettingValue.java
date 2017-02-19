package com.tolean.elab.business.impl.profile.settings.impl;

import com.tolean.elab.persistence.profile.setting.SettingType;
import com.tolean.elab.persistence.profile.setting.SettingValue;
import lombok.Data;

/**
 * Created by Tomasz Kołodziej
 */
@Data
public class LongDateFormatSettingValue extends SettingValue<String> {

    private String format;

    @Override
    public SettingType getType() {
        return SettingType.LONG_DATE_FORMAT;
    }

    @Override
    public String getDefaultValue() {
        return "dd-MM-yyyy HH:mm";
    }

}
