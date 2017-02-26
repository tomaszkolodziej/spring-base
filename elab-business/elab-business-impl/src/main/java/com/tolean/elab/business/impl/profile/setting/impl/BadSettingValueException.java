package com.tolean.elab.business.impl.profile.setting.impl;

import com.tolean.elab.tools.AppException;

/**
 * Created by Tomasz Kołodziej
 */
public class BadSettingValueException extends AppException {

    private static final String BAD_SETTING_VALUE = "BAD_SETTING_VALUE";

    public BadSettingValueException(String eid) {
        super(eid, BAD_SETTING_VALUE, "Wprowadzona wartość jest nieprawidłowa");
    }

    public BadSettingValueException(String eid, String message) {
        super(eid, BAD_SETTING_VALUE, message);
    }

}
