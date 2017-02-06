package com.tolean.elab.business.impl.dictionary;

import com.tolean.elab.business.api.dictionary.DictionaryService;
import com.tolean.elab.business.impl.dictionary.validator.DictionaryValidator;
import com.tolean.elab.dto.dictionary.DictionaryNewDto;
import com.tolean.elab.dto.dictionary.DictionaryUpdateDto;
import com.tolean.elab.dto.dictionary.DictionaryViewDto;
import com.tolean.elab.mapper.dictionary.DictionaryMapper;
import com.tolean.elab.persistence.dictionary.Dictionary;
import com.tolean.elab.persistence.dictionary.DictionaryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.wavesoftware.eid.exceptions.EidIllegalStateException;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * @author Tomasz Kołodziej <tomasz.kolodziej@coi.gov.pl>
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DictionaryServiceImpl implements DictionaryService {

  private final DictionaryRepository dictionaryRepository;
  private final DictionaryMapper dictionaryMapper;
  private final DictionaryValidator dictionaryValidator;


  public DictionaryViewDto getDictionary(Long id) {
    checkNotNull("20170214:1158", id);

    Dictionary dictionary = dictionaryRepository.findOne(id)
      .orElseThrow(() -> new EidIllegalStateException("20170114:1215", "Słownik o id " + id + " nie istnieje"));

    return dictionaryMapper.toDictionaryViewDto(dictionary);
  }

  @Override
  public DictionaryViewDto getDictionary(String code) {
    checkNotNull("20170131:1529", code);

    Dictionary dictionary = dictionaryRepository.findByCode(code)
      .orElseThrow(() -> new EidIllegalStateException("20170201:151458", "Słownik o kodzie " + code + " nie istnieje"));

    return dictionaryMapper.toDictionaryViewDto(dictionary);
  }

  @Override
  public DictionaryViewDto add(DictionaryNewDto dictionaryNewDto){
    checkNotNull("20170206:1629", dictionaryNewDto);

    Dictionary dictionary = dictionaryMapper.toDictionary(dictionaryNewDto);
    dictionaryValidator.check(dictionary);

    dictionary = dictionaryRepository.save(dictionary);

    return dictionaryMapper.toDictionaryViewDto(dictionary);
  }

  @Override
  public DictionaryViewDto update(DictionaryUpdateDto dictionaryUpdateDto){
    checkNotNull("20170206:1629", dictionaryUpdateDto);

    Dictionary dictionary = dictionaryRepository.findOne(dictionaryUpdateDto.getId())
      .orElseThrow(() -> new DictionaryNotFoundException("20170126:1857", dictionaryUpdateDto.getId()));
    dictionary.setCode(dictionaryUpdateDto.getCode());
    dictionary.setDescription(dictionaryUpdateDto.getName());
    dictionary.setDescription(dictionaryUpdateDto.getDescription());
    dictionary.setActive(dictionaryUpdateDto.isActive());
    dictionaryValidator.check(dictionary);

    dictionary = dictionaryRepository.save(dictionary);
    return dictionaryMapper.toDictionaryViewDto(dictionary);
  }

}
