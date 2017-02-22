package com.tolean.elab.dto.dictionary;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * @author Bartosz Olszanski <bartosz.olszanski@coi.gov.pl>
 */
@Data
@AllArgsConstructor
@Builder
public class DictionaryUpdateDto {

    String defaultValue;

}
