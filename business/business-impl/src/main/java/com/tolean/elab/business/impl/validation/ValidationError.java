package com.tolean.elab.business.impl.validation;

import com.google.common.collect.Maps;
import com.tolean.elab.commons.AppException;

import java.util.Map;

import static pl.wavesoftware.eid.utils.EidPreconditions.checkNotNull;

/**
 * Created by tomasz.kolodziej@poczta.pl
 */
public class ValidationError {

    private String id;
    private String code;
    private String message;
    private Object returnData;
    private Map<String, String> fieldErrors;

    private ValidationError() {
        // do nothing
    }

    private ValidationError(String id) {
        checkNotNull(id, "20170226:205601");

        this.id = id;
        this.fieldErrors = Maps.newHashMap();
    }

    public static ValidationError builder(String id) {
        return new ValidationError(id);
    }

    public ValidationError withCodeAndMessage(String code, String message) {
        this.code = code;
        this.message = message;
        return this;
    }

    public <T> ValidationError withReturnData(final T returnData) {
        this.returnData = returnData;
        return this;
    }

    public ValidationError fieldError(final String fieldName, final String message) {
        this.fieldErrors.put(fieldName, message);
        return this;
    }

    public ValidationError fieldRequired(final String fieldName) {
        this.fieldErrors.put(fieldName, String.format("Uzupełnij"));
        return this;
    }

    public ValidationError fieldMaxLength(final String fieldName, final int maxLenght) {
        this.fieldErrors.put(fieldName, String.format("Maks. długość to %d znaków", maxLenght));
        return this;
    }

    public void throwExceptionIfHasErrorsOnFields() {
        if (!this.fieldErrors.isEmpty()) {
            throwException("FIELDS_BAD_DATA", "Wprowadzono nieprawidłowe informacje.");
        }
    }

    public void throwException(String code, String message) {
        this.code = code;
        this.message = message;
        throwException();
    }

    public void throwException() {
        checkNotNull(code, "20170226:211001");
        checkNotNull(message, "20170226:211002");

        throw new AppException(id, code, message, returnData, fieldErrors);
    }

}
