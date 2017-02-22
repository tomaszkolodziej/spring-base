package com.tolean.elab.business.impl.validation;

import pl.wavesoftware.eid.exceptions.Eid;
import pl.wavesoftware.eid.exceptions.EidRuntimeException;

import java.util.Map;

/**
 * Created by Tomasz Kołodziej
 */
public class AppException extends EidRuntimeException {

    private String id;
    private String code;
    private String message;
    private Object returnData;
    private Map<String, String> fieldErrors;

  public AppException(Eid id, String messageFormat, Object... parameters) {
    super(id, messageFormat, parameters);
  }

  public AppException(String id, String code, String message, Object returnData, Map<String, String> fieldErrors) {
    this(new Eid(id), message);
    this.id = id;
    this.code = code;
    this.message = message;
    this.returnData = returnData;
    this.fieldErrors = fieldErrors;
  }

}
