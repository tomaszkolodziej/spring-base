package com.tolean.elab.business.api.dictionary;

import com.tolean.elab.dto.dictionary.DictionaryItemNewDto;
import com.tolean.elab.dto.dictionary.DictionaryItemUpdateDto;
import com.tolean.elab.dto.dictionary.DictionaryUpdateDto;
import com.tolean.elab.dto.dictionary.DictionaryViewDto;

/**
 * @author Tomasz Kołodziej <tomasz.kolodziej@coi.gov.pl>
 */
public interface DictionaryService {

  DictionaryViewDto getDictionary(String code);

  DictionaryViewDto addDictionaryItem(String code, DictionaryItemNewDto dictionaryItemNewDto);

  DictionaryViewDto updateDictionaryItem(String code, Long dictionaryItemId, DictionaryItemUpdateDto dictionaryItemUpdateDto);

  DictionaryViewDto update(String code, DictionaryUpdateDto dictionaryUpdateDto);

}
