package com.tolean.elab.mapper.dictionary;

import com.tolean.elab.dto.dictionary.DictionaryViewDto;
import com.tolean.elab.persistence.dictionary.Dictionary;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Bartosz Olszanski <bartosz.olszanski@coi.gov.pl>
 */
@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DictionaryMapperImpl implements DictionaryMapper{

  private final DictionaryItemMapper dictionaryItemMapper;

  @Override
  public DictionaryViewDto toDictionaryViewDto(Dictionary dictionary) {
      DictionaryViewDto dictionaryViewDto = new DictionaryViewDto();
      dictionaryViewDto.setCode(dictionary.getCode());
      dictionaryViewDto.setName(dictionary.getName());
      dictionaryViewDto.setActive(dictionary.isActive());
      dictionaryViewDto.setDefaultValue(dictionary.getDefaultValue() != null ? dictionary.getDefaultValue().getName() : "");
      dictionaryViewDto.setDictionaryItems(dictionaryItemMapper.toDictionaryItemViewDtoList(dictionary.getDictionaryItems()));
      return dictionaryViewDto;
  }
}
