package com.tolean.elab.persistence.profile.setting;

/**
 * Created by Tomasz Kołodziej
 */
public enum ValueType {

    STRING, BOOLEAN, STRING_LIST;

    public boolean isList() {
        return this == STRING_LIST;
    }

}
