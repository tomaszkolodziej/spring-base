package com.tolean.elab.persistence.profile.setting;

import lombok.Data;

/**
 * Created by Tomasz Kołodziej
 */
@Data
public abstract class SettingValue<V> {

    public abstract SettingType getType();

    public abstract V getDefaultValue();

}
