package com.tolean.elab.presentation.error;

import lombok.Data;

import java.util.Map;

/**
 * Created by tomasz.kolodziej@poczta.pl
 */
@Data
public class Error {

  private String id;
  private String code;
  private String message;
  private Object returnData;
  private Map<String, String> fieldErrors;

}
