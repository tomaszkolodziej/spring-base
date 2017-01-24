package com.tolean.elab.business.impl.validation;

import com.google.common.collect.Maps;

import java.util.Map;
import java.util.function.Supplier;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Preconditions.checkState;

/**
 * Example - global error:
 *
 *  new ExceptionBuilder("20161105:1355", "ERROR", "Exception message").thrown();
 *
 * Example - errors on fields:
 *
 *  new ExceptionBuilder("20161105:1356")
 *      .fields()
 *          .required("imie")
 *          .maxLength("imie", 100)
 *          .thrown();
 *
 * Created by Tomasz Kołodziej
 */
public class ExceptionBuilder {

    private final String id;
    private String code;
    private String message;
    private Object returnData;
    private Map<String, String> fieldErrors;

    public ExceptionBuilder(final String id) {
        this.id = checkNotNull(id, "id");
    }

    public ExceptionBuilder(final String id, final String code, final String message) {
        this(id);
        this.code = checkNotNull(code, "code");
        this.message = checkNotNull(message, "message");
    }

    public <T> ExceptionBuilder withReturnData(final T returnData) {
        this.returnData = returnData;
        return this;
    }

    public ExceptionBuilder fields() throws IllegalAccessException {
        if (this.fieldErrors != null) {
            throw new RuntimeException("Method can be run only once!");
        }
        this.fieldErrors = Maps.newHashMap();
        return this;
    }

    public ExceptionBuilder error(final String fieldName, final String message) {
        this.fieldErrors.put(fieldName, message);
        return this;
    }

    public ExceptionBuilder required(final String fieldName) {
        checkFieldsErrorExecuted(fieldName);
        this.fieldErrors.put(fieldName, String.format("uzupełnij"));
        return this;
    }

    public ExceptionBuilder maxLength(final String fieldName, final int maxLenght) {
        checkFieldsErrorExecuted(fieldName);
        this.fieldErrors.put(fieldName, String.format("maksymalna długość to %d znaków", maxLenght));
        return this;
    }

    public Supplier<AppException> throwExceptionSupplier() {
      return () -> new AppException(id, code, message, returnData, fieldErrors);
    }

    public void throwException() {
        throw new AppException(id, code, message, returnData, fieldErrors);
    }

    private void checkFieldsErrorExecuted(final String fieldName) {
        checkState(this.fieldErrors != null, "Run fields method first");
        checkArgument(!this.fieldErrors.containsKey(fieldName), String.format("Field name %s already used!", fieldName));
    }

}
