package com.tolean.elab.dto.dictionary;

import lombok.Data;

/**
 * Created by admin on 06.02.2017.
 */
@Data
public class DictionaryUpdateDto {

  private Long id;
  private String description;
  private boolean active;

}
