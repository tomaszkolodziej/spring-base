package com.tolean.elab.persistence.profile.setting;

import java.util.Set;

/**
 * Created by Tomasz Kołodziej
 */
public interface Parameter<V> {

    Group getGroup();

    String getName();

    String getDescription();

    V getValue();

    V getDefaultValue();

    Set<String> getAvailableValues();

    void checkValue();

    SettingAccessType getAccessType();

}
