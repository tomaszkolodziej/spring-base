package com.tolean.elab.business.impl.profile.setting.impl;

import com.google.common.collect.Sets;
import com.tolean.elab.persistence.profile.setting.value.SelectableSettingValue;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

/**
 * Created by Tomasz Kołodziej
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LongDateFormatSettingValue implements SelectableSettingValue<String> {

    private String value;

    @Override
    public String getDefaultValue() {
        return "dd-MM-yyyy HH:mm";
    }

    @Override
    public void checkValue() {
        if (!getAvailableValues().contains(value)) {
            throw new BadSettingValueException("20170221:212300");
        }
    }

    @Override
    public Set<String> getAvailableValues() {
        return Sets.newHashSet("dd-MM-yyyy HH:mm", "yyyy-MM-dd HH:mm");
    }

}
