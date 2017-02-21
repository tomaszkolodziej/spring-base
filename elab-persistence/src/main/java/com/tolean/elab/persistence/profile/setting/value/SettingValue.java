package com.tolean.elab.persistence.profile.setting.value;

/**
 * Created by Tomasz Kołodziej
 */
public interface SettingValue<V> {

    V getValue();

    V getDefaultValue();

    void checkValue();

}
