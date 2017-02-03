package com.tolean.elab.dto.dictionary;

import lombok.Data;
import java.util.List;

/**
 * @author Tomasz Kołodziej <tomasz.kolodziej@coi.gov.pl>
 */
@Data
public class DictionaryViewDto {

  private Long id;
  private String code;
  private String name;
  private boolean active;
  private List<DictionaryItemViewDto> dictionaryItems;

}
