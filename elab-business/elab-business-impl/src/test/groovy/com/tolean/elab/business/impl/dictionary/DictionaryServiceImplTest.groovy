package com.tolean.elab.business.impl.dictionary

import com.tolean.elab.mapper.dictionary.DictionaryMapper
import com.tolean.elab.persistence.dictionary.DictionaryRepository
import spock.lang.Specification

/**
 * @author Bartosz Olszanski <bartosz.olszanski@coi.gov.pl>
 */
class DictionaryServiceImplTest extends Specification {
  
    DictionaryRepository dictionaryRepository
    DictionaryMapper dictionaryMapper
    DictionaryServiceImpl dictionaryServiceImpl
    
    def setup() {
        dictionaryRepository = Mock(DictionaryRepository)
        dictionaryMapper = Mock(DictionaryMapper)
        dictionaryServiceImpl = new DictionaryServiceImpl(dictionaryRepository, dictionaryMapper)
    }
  
  def "updateDefaultValue should not throw any exception"() {
      when:
          dictionaryServiceImpl.updateDefaultValue("code", "default")
      then:
          1 * dictionaryMapper.toDictionaryViewDto(_)
  }
}
