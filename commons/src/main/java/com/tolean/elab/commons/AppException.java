package com.tolean.elab.commons;

import lombok.Getter;
import pl.wavesoftware.eid.exceptions.EidRuntimeException;

import java.util.Map;

/**
 * Created by Tomasz Kołodziej
 */
@Getter
public class AppException extends EidRuntimeException {

    private String id;
    private String code;
    private String message;
    private String devMessage;
    private Object returnData;
    private Map<String, String> fieldErrors;

    public AppException(String eid, String code, String message) {
        super(eid, message);
        this.code = code;
        this.message = message;
        this.devMessage = message;
    }

    public AppException(String eid, String code, String message, String devMessage) {
        this(eid, code, message);
        this.devMessage = devMessage;
    }

    public AppException(String eid, String code, String message, Object returnData, Map<String, String> fieldErrors) {
        this(eid, code, message);
        this.id = eid;
        this.message = message;
        this.devMessage = message;
        this.returnData = returnData;
        this.fieldErrors = fieldErrors;
    }

}
