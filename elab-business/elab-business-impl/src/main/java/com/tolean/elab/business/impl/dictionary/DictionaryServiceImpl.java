package com.tolean.elab.business.impl.dictionary;

import com.tolean.elab.business.api.dictionary.DictionaryService;
import com.tolean.elab.business.impl.dictionary.validator.DictionaryValidator;
import com.tolean.elab.dto.dictionary.DictionaryItemNewDto;
import com.tolean.elab.dto.dictionary.DictionaryViewDto;
import com.tolean.elab.mapper.dictionary.DictionaryMapper;
import com.tolean.elab.persistence.dictionary.Dictionary;
import com.tolean.elab.persistence.dictionary.DictionaryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.wavesoftware.eid.exceptions.EidIllegalStateException;

import static pl.wavesoftware.eid.utils.EidPreconditions.checkNotNull;

/**
 * @author Tomasz Kołodziej <tomasz.kolodziej@coi.gov.pl>
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DictionaryServiceImpl implements DictionaryService {

  private final DictionaryRepository dictionaryRepository;
  private final DictionaryMapper dictionaryMapper;
  private final DictionaryValidator dictionaryValidator;


  public DictionaryViewDto getDictionary(String code) {
    checkNotNull("20170131:1529", code);

    Dictionary dictionary = dictionaryRepository.findByCode(code)
      .orElseThrow(() -> new EidIllegalStateException("20170201:151458", "Słownik o kodzie " + code + " nie istnieje"));

    return dictionaryMapper.toDictionaryViewDto(dictionary);
  }

  @Override
  public DictionaryViewDto addDictionaryItem(String dictionaryCode, DictionaryItemNewDto dictionaryItemNewDto){
    checkNotNull(dictionaryItemNewDto, "20170206:1629");

    Dictionary dictionary = dictionaryRepository.findByCode(dictionaryCode)
      .orElseThrow(() -> new EidIllegalStateException("20170201:151458", "Słownik o kodzie " + dictionaryCode + " nie istnieje"));

    dictionaryValidator.check(dictionary);

    dictionary = dictionaryRepository.save(dictionary);
    return dictionaryMapper.toDictionaryViewDto(dictionary);
  }

}
