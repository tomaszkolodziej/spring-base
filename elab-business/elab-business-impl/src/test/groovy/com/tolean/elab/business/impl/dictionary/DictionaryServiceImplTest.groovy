package com.tolean.elab.business.impl.dictionary

import com.tolean.elab.business.impl.dictionary.validator.DictionaryValidator
import com.tolean.elab.dto.dictionary.DictionaryItemNewDto
import com.tolean.elab.mapper.dictionary.DictionaryItemMapper
import com.tolean.elab.mapper.dictionary.DictionaryMapper
import com.tolean.elab.persistence.dictionary.DictionaryItem
import com.tolean.elab.persistence.dictionary.DictionaryRepository
import spock.lang.Specification

/**
 * Created by Janusz Nocek on 2017-02-13.
 */
class DictionaryServiceImplTest extends Specification {

  DictionaryRepository dictionaryRepositoryMock
  DictionaryMapper dictionaryMapperMock
  DictionaryItemMapper dictionaryItemMapperMock
  DictionaryValidator dictionaryValidatorMock
  DictionaryServiceImpl dictionaryService

  def setup() {
    dictionaryRepositoryMock = Mock(DictionaryRepository) {
      findByCode("nie istnieje") >> Optional.empty()
    }

    dictionaryMapperMock = Mock(DictionaryMapper)
    dictionaryItemMapperMock = Mock(DictionaryItemMapper)
    dictionaryValidatorMock = Mock(DictionaryValidator)

    dictionaryService = new DictionaryServiceImpl(dictionaryRepositoryMock, dictionaryMapperMock,
      dictionaryItemMapperMock, dictionaryValidatorMock)
  }

  def "addDictionaryItem should throw exception if dictionary with given code not exist"() {
    when:
      dictionaryService.addDictionaryItem("nie istnieje", new DictionaryItemNewDto())
    then:
      def exception = thrown(DictionaryNotFoundException)
      exception.eid.id == "20170206:151458"
  }

  def "addDictionaryItem should add new dictionary item"() {
    given:
      com.tolean.elab.persistence.dictionary.Dictionary dictionary = com.tolean.elab.persistence.dictionary.Dictionary.builder()
        .dictionaryItems([DictionaryItem.builder().name("item1").build()])
        .build()

      dictionaryRepositoryMock = Mock(DictionaryRepository) {
        findByCode("nie istnieje") >> Optional.empty()

        findByCode("kod") >> Optional.of(dictionary)
      }

      DictionaryItemNewDto dictionaryItemNewDto = DictionaryItemNewDto.builder().name("nowa").build()

      dictionaryItemMapperMock.toDictionaryItem(dictionaryItemNewDto) >> Mock(DictionaryItem) {
        getName() >> "nowa"
      }

      dictionaryService = new DictionaryServiceImpl(dictionaryRepositoryMock, dictionaryMapperMock,
        dictionaryItemMapperMock, dictionaryValidatorMock)
    when:
      dictionaryService.addDictionaryItem("kod", dictionaryItemNewDto)
    then:
      1 * dictionaryValidatorMock.check(dictionary, dictionaryItemNewDto)
      dictionary.dictionaryItems.name.contains("nowa")
      1 * dictionaryRepositoryMock.save(dictionary)
      1 * dictionaryMapperMock.toDictionaryViewDto(_)
  }

}
