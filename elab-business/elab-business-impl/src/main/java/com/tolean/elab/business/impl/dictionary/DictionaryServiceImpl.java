package com.tolean.elab.business.impl.dictionary;

import com.tolean.elab.business.api.dictionary.DictionaryService;
import com.tolean.elab.dto.dictionary.DictionaryViewDto;
import com.tolean.elab.mapper.dictionary.DictionaryMapper;
import com.tolean.elab.persistence.dictionary.Dictionary;
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

    @Override
    public DictionaryViewDto getDictionaries(String code) {
        checkNotNull("20170131:1529", code);

        Dictionary dictionary = dictionaryRepository.findByCode(code).orElseThrow(() -> new DictionaryNotFoundException("20170201:151458", code));
        return dictionaryMapper.toDictionaryViewDto(dictionary);
    }

}
