package com.tolean.elab.persistence.dictionary;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Optional;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * @author Tomasz Kołodziej <tomasz.kolodziej@coi.gov.pl>
 */
@Repository
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DictionaryRepository {

  private final DictionaryBaseRepository dictionaryBaseRepository;

  public Optional<Dictionary>  findOne(Long id){
    checkNotNull("20170131:1521", id);

    return Optional.ofNullable(dictionaryBaseRepository.findOne(id));
  }

  public Optional<Dictionary> findByCode(String code) {
    checkNotNull("20170131:1520", code);

    return Optional.ofNullable(dictionaryBaseRepository.findOneByCode(code));
  }

  public Dictionary save(Dictionary dictionary){

    return dictionaryBaseRepository.save(dictionary);
  }
}
