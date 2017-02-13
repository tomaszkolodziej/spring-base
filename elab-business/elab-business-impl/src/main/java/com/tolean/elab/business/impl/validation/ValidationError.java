package com.tolean.elab.business.impl.validation;

import com.google.common.collect.Maps;
import pl.wavesoftware.eid.exceptions.EidRuntimeException;

import java.util.Map;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkState;
import static org.apache.commons.lang3.StringUtils.isBlank;
import static pl.wavesoftware.eid.utils.EidPreconditions.checkNotNull;

/**
 * Example - global error:
 * <p>
 * ValidationError.builder().id("20161105:135500").code("ERROR").message("Exception message").thrown();
 * <p>
 * Example - errors on fields:
 * <p>
 * ValidationError.builder()
 * .id("20161105:1356")
 * .fields()
 * .required("imie")
 * .maxLength("imie", 100)
 * .thrown();
 * <p>
 * Created by tomasz.kolodziej@poczta.pl
 */
public class ValidationError {

    private String id;
    private String code;
    private String message;
    private Object returnData;
    private Map<String, String> fieldErrors;

    public static ValidationError builder() {
        return new ValidationError();
    }

    public ValidationError id(String id) {
        this.id = checkNotNull("20170125:0910", id);
        return this;
    }

    public ValidationError code(String code) {
        this.code = code;
        return this;
    }

    public ValidationError message(String message) {
        this.message = message;
        return this;
    }

    public ValidationError standardValidationError() {
        this.code = "BLAD_DANYCH";
        this.message = "Błąd w walidowanych danych";
        return this;
    }

    public <T> ValidationError withReturnData(final T returnData) {
        this.returnData = returnData;
        return this;
    }

    public ValidationError fields() {
        if (this.fieldErrors == null) {
            this.fieldErrors = Maps.newHashMap();
        }
        return this;
    }

    public ValidationError error(final String fieldName, final String message) {
        this.fieldErrors.put(fieldName, message);
        return this;
    }

    public ValidationError required(final String fieldName) {
        checkFieldsErrorExecuted(fieldName);
        this.fieldErrors.put(fieldName, String.format("uzupełnij"));
        return this;
    }

    public ValidationError maxLength(final String fieldName, final int maxLenght) {
        checkFieldsErrorExecuted(fieldName);
        this.fieldErrors.put(fieldName, String.format("maksymalna długość to %d znaków", maxLenght));
        return this;
    }

    public void throwExceptionIfHasErrorsOnFields() {
        if (!this.fieldErrors.isEmpty()) {
            throwException();
        }
    }

    public void throwException() {
        if (isBlank(id)) {
            throw new EidRuntimeException("20170125:0921", "Id nie może być null.");
        }
        throw new AppException(id, code, message, returnData, fieldErrors);
    }

    private void checkFieldsErrorExecuted(final String fieldName) {
        checkState(this.fieldErrors != null, "Run fields method first");
        checkArgument(!this.fieldErrors.containsKey(fieldName), String.format("Field name %s already used!", fieldName));
    }

}
