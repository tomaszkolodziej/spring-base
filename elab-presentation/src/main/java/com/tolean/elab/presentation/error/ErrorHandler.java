package com.tolean.elab.presentation.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import pl.wavesoftware.eid.exceptions.EidRuntimeException;

/**
 * Created by Tomasz Kołodziej
 */
@ControllerAdvice
public class ErrorHandler {

    @ResponseBody
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = EidRuntimeException.class)
    public ResponseEntity<Error> handleValidationException(EidRuntimeException appException) {
        return new ResponseEntity(createError(appException), HttpStatus.BAD_REQUEST);
    }

    private Error createError(EidRuntimeException exception) {
        return new Error();
    }

}
