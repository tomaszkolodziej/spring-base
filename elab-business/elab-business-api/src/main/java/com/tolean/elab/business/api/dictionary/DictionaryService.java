package com.tolean.elab.business.api.dictionary;

import com.tolean.elab.dto.dictionary.DictionaryViewDto;

/**
 * @author Tomasz Kołodziej <tomasz.kolodziej@coi.gov.pl>
 */
public interface DictionaryService {

  DictionaryViewDto getDictionaries(String code);

  DictionaryViewDto getDictionaries(Long id);

}
