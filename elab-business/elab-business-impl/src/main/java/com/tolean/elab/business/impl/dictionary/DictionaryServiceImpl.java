package com.tolean.elab.business.impl.dictionary;

import com.tolean.elab.business.api.dictionary.DictionaryService;
import com.tolean.elab.business.impl.dictionary.validator.DictionaryValidator;
import com.tolean.elab.dto.dictionary.DictionaryItemNewDto;
import com.tolean.elab.dto.dictionary.DictionaryItemUpdateDto;
import com.tolean.elab.dto.dictionary.DictionaryViewDto;
import com.tolean.elab.mapper.dictionary.DictionaryItemMapper;
import com.tolean.elab.mapper.dictionary.DictionaryMapper;
import com.tolean.elab.persistence.dictionary.Dictionary;
import com.tolean.elab.persistence.dictionary.DictionaryItem;
import com.tolean.elab.persistence.dictionary.DictionaryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.wavesoftware.eid.exceptions.EidIllegalStateException;

import java.util.Optional;

import static pl.wavesoftware.eid.utils.EidPreconditions.checkNotNull;

/**
 * @author Tomasz Kołodziej <tomasz.kolodziej@coi.gov.pl>
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DictionaryServiceImpl implements DictionaryService {

  private final DictionaryRepository dictionaryRepository;
  private final DictionaryMapper dictionaryMapper;
  private final DictionaryItemMapper dictionaryItemMapper;
  private final DictionaryValidator dictionaryValidator;

  public DictionaryViewDto getDictionary(String code) {
    checkNotNull("20170131:152913", code);

    Dictionary dictionary = dictionaryRepository.findByCode(code)
      .orElseThrow(() -> new DictionaryNotFoundException("20170201:151458", code));

    return dictionaryMapper.toDictionaryViewDto(dictionary);
  }

  @Override
  public DictionaryViewDto addDictionaryItem(String dictionaryCode, DictionaryItemNewDto dictionaryItemNewDto) {
    checkNotNull(dictionaryCode, "20170206:162901");
    checkNotNull(dictionaryItemNewDto, "20170206:162900");

    Dictionary dictionary = dictionaryRepository.findByCode(dictionaryCode)
      .orElseThrow(() -> new DictionaryNotFoundException("20170206:151458", dictionaryCode));

    dictionaryValidator.check(dictionary, dictionaryItemNewDto);

    DictionaryItem item = dictionaryItemMapper.toDictionaryItem(dictionaryItemNewDto);
    item.setActive(true);

    dictionary.getDictionaryItems().add(item);
    dictionary = dictionaryRepository.save(dictionary);

    return dictionaryMapper.toDictionaryViewDto(dictionary);
  }

  @Override
  public DictionaryViewDto updateDictionaryItem(String dictionaryCode, DictionaryItemUpdateDto dictionaryItemUpdateDto) {
    checkNotNull(dictionaryCode, "20170212:162904");
    checkNotNull(dictionaryItemUpdateDto, "20170212:162905");

    Dictionary dictionary = dictionaryRepository.findByCode(dictionaryCode)
      .orElseThrow(() -> new DictionaryNotFoundException("20170212:151459", dictionaryCode));

    DictionaryItem dictionaryItem = dictionary.getDictionaryItem(dictionaryItemUpdateDto.getId());
    dictionaryItemMapper.intoDictionaryItem(dictionaryItemUpdateDto, dictionaryItem);
    dictionary = dictionaryRepository.save(dictionary);

    return dictionaryMapper.toDictionaryViewDto(dictionary);
  }

}
