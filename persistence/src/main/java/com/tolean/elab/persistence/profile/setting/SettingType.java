package com.tolean.elab.persistence.profile.setting;

import lombok.Getter;
import pl.wavesoftware.eid.exceptions.EidIllegalStateException;

import java.util.Arrays;

import static pl.wavesoftware.eid.utils.EidPreconditions.checkNotNull;

/**
 * Created by Tomasz Kołodziej
 */
@Getter
public enum SettingType {

    LONG_DATE_FORMAT("longDateFormat"),
    SHORT_DATE_FORMAT("shortDateFormat");

    private final String name;

    SettingType(String name) {
        this.name = name;
    }

    public static SettingType getByName(String name) {
        checkNotNull(name, "20170223:124300");

        return Arrays.stream(values())
                .filter(settingType -> settingType.toString().equals(name))
                .findFirst()
                .orElseThrow(() -> new EidIllegalStateException("20170223:213303", "Nie odnaleziono typu na podstawie wartosci " + name));
    }

}
