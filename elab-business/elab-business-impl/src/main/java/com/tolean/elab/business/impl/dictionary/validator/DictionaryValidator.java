package com.tolean.elab.business.impl.dictionary.validator;

import com.tolean.elab.dto.dictionary.DictionaryItemNewDto;
import com.tolean.elab.persistence.dictionary.Dictionary;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import pl.wavesoftware.eid.exceptions.EidIllegalArgumentException;
import pl.wavesoftware.eid.exceptions.EidIllegalStateException;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by admin on 06.02.2017.
 */
@Component
public class DictionaryValidator {

    public void check(Dictionary dictionary, DictionaryItemNewDto dictionaryItemNewDto) {
        checkNotNull("20170206:190923", dictionary);
        checkNotNull("20170206:190642", dictionaryItemNewDto);

        if (StringUtils.isBlank(dictionaryItemNewDto.getName())) {
            throw new EidIllegalArgumentException("20170213:150300", "Pole nazwa jest wymagane.");
        }

        boolean dictionaryItemNameAlreadyExist = dictionary.getDictionaryItems().stream()
                .anyMatch(dictionaryItem -> dictionaryItem.getName().equalsIgnoreCase(dictionaryItemNewDto.getName()));

        if (dictionaryItemNameAlreadyExist) {
            throw new EidIllegalStateException("20170213:150400", "Pole o nazwie '" + dictionaryItemNewDto.getName() + "' już istnieje.");
        }
    }

}
