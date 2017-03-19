package com.tolean.elab.business.impl.profile.setting.impl;

import com.google.common.collect.Sets;
import com.tolean.elab.persistence.profile.setting.Group;
import com.tolean.elab.persistence.profile.setting.Parameter;
import com.tolean.elab.persistence.profile.setting.SettingAccessType;
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
public class LongDateFormatParameter implements Parameter<String> {

    private String value;

    @Override
    public Group getGroup() {
        return Group.dateAndTimeGroup();
    }

    @Override
    public String getName() {
        return "Długi format daty";
    }

    @Override
    public String getDescription() {
        return "Określa jaki będzie długi format daty używany w systemie.";
    }

    @Override
    public String getDefaultValue() {
        return "dd-MM-yyyy HH:mm";
    }

    @Override
    public Set<String> getAvailableValues() {
        return Sets.newHashSet("dd-MM-yyyy HH:mm", "yyyy-MM-dd HH:mm");
    }

    @Override
    public void checkValue() {
        if (!getAvailableValues().contains(value)) {
            throw new BadSettingValueException("20170221:212300");
        }
    }

    @Override
    public SettingAccessType getAccessType() {
        return SettingAccessType.ONLY_SERVICE;
    }
}
