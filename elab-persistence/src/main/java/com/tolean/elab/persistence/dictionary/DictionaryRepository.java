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
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DictionaryRepository {

    private final DictionaryBaseRepository dictionaryBaseRepository;

    public Optional<Dictionary> findByCode(String code) {
        checkNotNull("20170131:1520", code);

        Dictionary dictionary = dictionaryBaseRepository.findByCode(code);
        return Optional.ofNullable(dictionary);
    }

}
