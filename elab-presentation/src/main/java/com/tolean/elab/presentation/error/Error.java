package com.tolean.elab.presentation.error;

import com.tolean.elab.tools.AppException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * Created by tomasz.kolodziej@poczta.pl
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Error {

    private String id;
    private String code;
    private String message;
    private String devMessage;
    private Object returnData;
    private Map<String, String> fieldErrors;

    public Error(AppException appException) {
        this.id = appException.getEid().getId();
        this.code = appException.getCode();
        this.message = appException.getMessage();
        this.devMessage = appException.getDevMessage();
        this.returnData = appException.getReturnData();
        this.fieldErrors = appException.getFieldErrors();
    }

}
