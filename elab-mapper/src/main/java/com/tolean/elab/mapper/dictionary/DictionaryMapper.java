package com.tolean.elab.mapper.dictionary;

import com.tolean.elab.dto.dictionary.DictionaryItemNewDto;
import com.tolean.elab.dto.dictionary.DictionaryViewDto;
import com.tolean.elab.persistence.dictionary.Dictionary;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * @author Tomasz Kołodziej <tomasz.kolodziej@coi.gov.pl>
 */
@Mapper(uses = DictionaryItemMapper.class)
public interface DictionaryMapper {

  DictionaryViewDto toDictionaryViewDto(Dictionary dictionary);

//  @Mapping(target = "id", ignore = true)
//  @Mapping(target = "code", ignore = true)
//  @Mapping(target = "description", ignore = true)
//  @Mapping(target = "active", ignore = true)
//  @Mapping(target = "dictionaryItems", ignore = true)
//
//   Dictionary toDictionary(DictionaryNewDto dictionaryNewDtoewDto);

}
