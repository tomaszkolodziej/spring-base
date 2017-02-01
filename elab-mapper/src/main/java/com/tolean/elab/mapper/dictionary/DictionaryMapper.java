package com.tolean.elab.mapper.dictionary;

import com.tolean.elab.dto.dictionary.DictionaryViewDto;
import com.tolean.elab.persistence.dictionary.Dictionary;
import org.mapstruct.Mapper;

/**
 * @author Tomasz Kołodziej <tomasz.kolodziej@coi.gov.pl>
 */
@Mapper(uses = DictionaryItemMapper.class)
public interface DictionaryMapper {

  DictionaryViewDto toDictionaryViewDto(Dictionary dictionary);

}
