package com.tolean.elab.business.impl.dictionary

import com.tolean.elab.business.impl.dictionary.validator.DictionaryValidator
import com.tolean.elab.dto.dictionary.DictionaryItemNewDto
import com.tolean.elab.dto.dictionary.DictionaryUpdateDto
import com.tolean.elab.mapper.dictionary.DictionaryItemMapper
import com.tolean.elab.mapper.dictionary.DictionaryMapper
import com.tolean.elab.persistence.dictionary.Dictionary
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

    dictionaryService = getDictionaryServiceImpl(dictionaryRepositoryMock, dictionaryMapperMock, dictionaryItemMapperMock, dictionaryValidatorMock)
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
      Dictionary dictionary = Dictionary.builder()
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

      dictionaryService = getDictionaryServiceImpl(dictionaryRepositoryMock, dictionaryMapperMock, dictionaryItemMapperMock, dictionaryValidatorMock)
    when:
      dictionaryService.addDictionaryItem("kod", dictionaryItemNewDto)
    then:
      1 * dictionaryValidatorMock.check(dictionary, dictionaryItemNewDto)
      dictionary.dictionaryItems.name.contains("nowa")
      1 * dictionaryRepositoryMock.save(dictionary)
      1 * dictionaryMapperMock.toDictionaryViewDto(_)
  }

  def "update should save dictionary"() {
    given:
      String dictionaryName = "dictionaryName"
      String dictionaryItemValue = "value"
      Dictionary dictionary = Dictionary.builder()
        .code(dictionaryName)
        .dictionaryItems([DictionaryItem.builder().active(true).name(dictionaryItemValue).build()])
        .build()

      dictionaryRepositoryMock = Mock(DictionaryRepository) {
        findByCode(dictionaryName) >> Optional.of(dictionary)
      }

      dictionaryService = getDictionaryServiceImpl(dictionaryRepositoryMock, dictionaryMapperMock, dictionaryItemMapperMock, dictionaryValidatorMock)
    when:
      dictionaryService.update(dictionaryName, new DictionaryUpdateDto(dictionaryItemValue))
    then:
      1 * dictionaryRepositoryMock.save(dictionary)
  }

  def "update should throw exception when value is not active in dictionary items"() {
    given:
      String dictionaryName = "dictionaryName"
      String dictionaryItemValue = "value"
      Dictionary dictionary = Dictionary.builder()
        .code(dictionaryName)
        .dictionaryItems([DictionaryItem.builder().name(dictionaryItemValue).build()])
        .build()

      dictionaryRepositoryMock = Mock(DictionaryRepository) {
        findByCode(dictionaryName) >> Optional.of(dictionary)
      }

      dictionaryService = getDictionaryServiceImpl(dictionaryRepositoryMock, dictionaryMapperMock, dictionaryItemMapperMock, dictionaryValidatorMock)
    when:
      dictionaryService.update(dictionaryName, new DictionaryUpdateDto(dictionaryItemValue))
    then:
      def exception = thrown(DictionaryItemNotFoundException)
      exception.eid.id == "20170221:194603"
  }

  private DictionaryServiceImpl getDictionaryServiceImpl(DictionaryRepository dictionaryRepositoryMock, DictionaryMapper dictionaryMapperMock, DictionaryItemMapper dictionaryItemMapperMock, DictionaryValidator dictionaryValidatorMock) {
    new DictionaryServiceImpl(dictionaryRepositoryMock, dictionaryMapperMock,
      dictionaryItemMapperMock, dictionaryValidatorMock)
  }

}
