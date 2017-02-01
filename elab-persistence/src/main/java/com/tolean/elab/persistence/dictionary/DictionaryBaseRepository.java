package com.tolean.elab.persistence.dictionary;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Tomasz Kołodziej <tomasz.kolodziej@coi.gov.pl>
 */
@Repository
public interface DictionaryBaseRepository extends CrudRepository<Dictionary, Long> {

  Dictionary findByCode(String code);

}
