package com.tolean.elab.business.impl.profile.settings.impl;

import com.tolean.elab.persistence.profile.setting.value.SettingValue;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Tomasz Kołodziej
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LongDateFormatSettingValue implements SettingValue<String> {

    private static final String DEFAULT_VALUE = "dd-MM-yyyy HH:mm";

    private String value;

    @Override
    public String getDefaultValue() {
        return DEFAULT_VALUE;
    }

    @Override
    public void checkValue() {
        if (!DEFAULT_VALUE.equals(value) && !"yyyy-MM-dd HH:mm".equals(value)) {
            throw new BadSettingValueException("20170221:212300");
        }
    }

}
