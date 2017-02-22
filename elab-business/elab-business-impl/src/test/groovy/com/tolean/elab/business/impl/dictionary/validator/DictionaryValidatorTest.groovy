package com.tolean.elab.business.impl.dictionary.validator

import com.tolean.elab.dto.dictionary.DictionaryItemNewDto
import com.tolean.elab.persistence.dictionary.DictionaryItem
import pl.wavesoftware.eid.exceptions.EidIllegalArgumentException
import pl.wavesoftware.eid.exceptions.EidIllegalStateException
import spock.lang.Specification

/**
 * Created by Janusz Nocek on 2017-02-13.
 */
class DictionaryValidatorTest extends Specification {

    DictionaryValidator dictionaryValidator

    def setup() {
        dictionaryValidator = new DictionaryValidator()
    }

    def "should throw exception if name not provided"() {
        when:
            dictionaryValidator.check(new com.tolean.elab.persistence.dictionary.Dictionary(), new DictionaryItemNewDto())
        then:
            def exception = thrown(EidIllegalArgumentException)
            exception.eid.id == "20170213:150300"
    }

    def "should throw exception if dictionary item name already exist in dictionary item list"() {
        given:
            com.tolean.elab.persistence.dictionary.Dictionary dictionary = com.tolean.elab.persistence.dictionary.Dictionary.builder()
                .dictionaryItems([DictionaryItem.builder().name("istnieje").build()])
                .build();
        when:
            dictionaryValidator.check(dictionary, DictionaryItemNewDto.builder().name("istnieje").build())
        then:
            def exception = thrown(EidIllegalStateException)
            exception.eid.id == "20170213:150400"
    }

}
