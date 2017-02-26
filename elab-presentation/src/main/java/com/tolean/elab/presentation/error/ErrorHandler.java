package com.tolean.elab.presentation.error;

import com.tolean.elab.tools.AppException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Tomasz Kołodziej
 */
@ControllerAdvice
public class ErrorHandler {

    @ResponseBody
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = AppException.class)
    public ResponseEntity<Error> handleValidationException(AppException appException) {
        return new ResponseEntity(createError(appException), HttpStatus.BAD_REQUEST);
    }

    private Error createError(AppException appException) {
        return new Error(appException);
    }

}
