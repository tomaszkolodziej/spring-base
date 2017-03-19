package com.tolean.elab.business.impl.dictionary;

import com.tolean.elab.business.api.dictionary.DictionaryService;
import com.tolean.elab.business.impl.dictionary.validator.DictionaryValidator;
import com.tolean.elab.dto.dictionary.DictionaryItemNewDto;
import com.tolean.elab.dto.dictionary.DictionaryItemUpdateDto;
import com.tolean.elab.dto.dictionary.DictionaryUpdateDto;
import com.tolean.elab.dto.dictionary.DictionaryViewDto;
import com.tolean.elab.mapper.dictionary.DictionaryItemMapper;
import com.tolean.elab.mapper.dictionary.DictionaryMapper;
import com.tolean.elab.persistence.dictionary.Dictionary;
import com.tolean.elab.persistence.dictionary.DictionaryItem;
import com.tolean.elab.persistence.dictionary.DictionaryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        checkNotNull(code, "20170131:152913");

        Dictionary dictionary = dictionaryRepository.findByCode(code)
                .orElseThrow(() -> new DictionaryNotFoundException("20170201:151458", code));

        return dictionaryMapper.toDictionaryViewDto(dictionary);
    }

    @Override
    public DictionaryViewDto addDictionaryItem(String code, DictionaryItemNewDto dictionaryItemNewDto) {
        checkNotNull(code, "20170131:152900");
        checkNotNull(dictionaryItemNewDto, "20170131:152901");

        Dictionary dictionary = dictionaryRepository.findByCode(code)
                .orElseThrow(() -> new DictionaryNotFoundException("20170206:151458", code));

        dictionaryValidator.check(dictionary, dictionaryItemNewDto);

        DictionaryItem item = dictionaryItemMapper.toDictionaryItem(dictionaryItemNewDto);
        item.setActive(true);

        dictionary.getDictionaryItems().add(item);
        dictionary = dictionaryRepository.save(dictionary);

        return dictionaryMapper.toDictionaryViewDto(dictionary);
    }

    @Override
    public DictionaryViewDto updateDictionaryItem(String dictionaryCode, Long dictionaryItemId, DictionaryItemUpdateDto dictionaryItemUpdateDto) {
        checkNotNull(dictionaryCode, "20170212:162904");
        checkNotNull(dictionaryItemId, "20170221:214900");
        checkNotNull(dictionaryItemUpdateDto, "20170212:162905");

        Dictionary dictionary = dictionaryRepository.findByCode(dictionaryCode)
                .orElseThrow(() -> new DictionaryNotFoundException("20170212:151459", dictionaryCode));

        DictionaryItem dictionaryItem = dictionary.getDictionaryItem(dictionaryItemId);
        dictionaryItemMapper.intoDictionaryItem(dictionaryItemUpdateDto, dictionaryItem);
        dictionary = dictionaryRepository.save(dictionary);

        return dictionaryMapper.toDictionaryViewDto(dictionary);
    }

    @Override
    public DictionaryViewDto updateDefaultValue(String code, DictionaryUpdateDto dictionaryUpdateDto) {
        checkNotNull("20170221:1912", code);

        Dictionary dictionary = findByCode(code);
        if (dictionaryUpdateDto == null) {
            dictionary.setDefaultValue(null);
        } else {
            DictionaryItem dictionaryItem = dictionary.getDictionaryItems().stream()
                .filter(value -> value.isActive() && value.getName().equals(dictionaryUpdateDto.getDefaultValue()))
                .findFirst()
                .orElseThrow(() -> new DictionaryItemNotFoundException("20170221:194603", dictionaryUpdateDto.getDefaultValue()));
            dictionary.setDefaultValue(dictionaryItem.getName());
        }
        dictionary = dictionaryRepository.save(dictionary);
        return dictionaryMapper.toDictionaryViewDto(dictionary);
    }

    private Dictionary findByCode(String code) {
        return dictionaryRepository.findByCode(code).orElseThrow(() -> new DictionaryNotFoundException("20170201:151458", code));
    }
}
