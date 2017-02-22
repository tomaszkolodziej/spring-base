package com.tolean.elab.business.impl.profile.settings.impl;

import pl.wavesoftware.eid.exceptions.EidIllegalArgumentException;

/**
 * Created by Tomasz Kołodziej
 */
public class BadSettingValueException extends EidIllegalArgumentException {

    public BadSettingValueException(String eid) {
        super(eid, "Wprowadzona wartość jest nieprawidłowa");
    }

    public BadSettingValueException(String eid, String message) {
        super(eid, message);
    }

}
