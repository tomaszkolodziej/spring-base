package com.tolean.elab.persistence.profile.setting.value;

import java.util.Set;

/**
 * Created by Tomasz Kołodziej
 */
public interface SelectableSettingValue<V> extends SettingValue<V> {

    Set<String> getAvailableValues();

}
