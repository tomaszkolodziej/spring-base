package com.tolean.elab.mapper.dictionary;

import com.tolean.elab.dto.dictionary.DictionaryViewDto;
import com.tolean.elab.persistence.dictionary.Dictionary;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Tomasz Kołodziej
 */
public class DictionaryMapperTest {

    private DictionaryMapper dictionaryMapper;

    @Before
    public void setup() {
        //dictionaryMapper = new DictionaryMapper();
    }

    @Test
    @Ignore
    public void shouldMapDictionaryToDictionaryViewDto() {
        Dictionary dictionary = new Dictionary();
        dictionary.setCode("code");

        DictionaryViewDto dictionaryViewDto = dictionaryMapper.toDictionaryViewDto(dictionary);

        assertThat(dictionaryViewDto.getCode()).isEqualTo(dictionary.getCode());
    }

}
