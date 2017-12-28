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
public class ShortDateFormatParameter implements Parameter<String> {

    private String value;

    @Override
    public Group getGroup() {
        return Group.dateAndTimeGroup();
    }

    @Override
    public String getName() {
        return "Krótki format daty";
    }

    @Override
    public String getDescription() {
        return "Określa jaki będzie krótki format daty używany w systemie.";
    }

    @Override
    public String getDefaultValue() {
        return "dd-MM-yyyy";
    }

    @Override
    public Set<String> getAvailableValues() {
        return Sets.newHashSet("dd-MM-yyyy", "yyyy-MM-dd");
    }

    @Override
    public void checkValue() {
        if (!getAvailableValues().contains(value)) {
            throw new BadSettingValueException("20170221:212100");
        }
    }

    @Override
    public SettingAccessType getAccessType() {
        return SettingAccessType.ONLY_SERVICE;
    }

}
