package com.tolean.elab.persistence.dictionary;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import static pl.wavesoftware.eid.utils.EidPreconditions.checkNotNull;

/**
 * @author Tomasz Kołodziej <tomasz.kolodziej@coi.gov.pl>
 */
@Repository
@RequiredArgsConstructor
public class DictionaryRepository {

    @Autowired
    private final DictionaryBaseRepository dictionaryBaseRepository;

    public Optional<Dictionary> findByCode(String code) {
        checkNotNull(code, "20170131:152012");

        return Optional.ofNullable(dictionaryBaseRepository.findOneByCode(code));
    }

    public Dictionary save(Dictionary dictionary) {
        checkNotNull(dictionary, "20170131:152001");

        return dictionaryBaseRepository.save(dictionary);
    }

}
