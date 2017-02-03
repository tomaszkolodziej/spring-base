package com.tolean.elab.business.api.dictionary;

import com.tolean.elab.dto.dictionary.DictionaryViewDto;

/**
 * @author Tomasz Kołodziej <tomasz.kolodziej@coi.gov.pl>
 */
public interface DictionaryService {

  DictionaryViewDto getDictionary(String code);

  DictionaryViewDto getDictionary(Long id);

}
