package com.tolean.elab.mapper.dictionary;

import com.tolean.elab.dto.dictionary.DictionaryItemNewDto;
import com.tolean.elab.dto.dictionary.DictionaryItemViewDto;
import com.tolean.elab.persistence.dictionary.DictionaryItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * @author Tomasz Kołodziej <tomasz.kolodziej@coi.gov.pl>
 */
@Mapper
public interface DictionaryItemMapper {

  DictionaryItemViewDto toDictionaryItemViewDto(DictionaryItem dictionaryItem);

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "active", defaultValue = "true")
  DictionaryItem toDictionaryItem(DictionaryItemNewDto dictionaryItemNewDto);

}
