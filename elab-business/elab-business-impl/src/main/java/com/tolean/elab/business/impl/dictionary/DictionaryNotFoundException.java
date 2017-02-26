package com.tolean.elab.business.impl.dictionary;

import com.tolean.elab.tools.AppException;

/**
 * Created by tomasz.kolodziej@poczta.pl
 */
public class DictionaryNotFoundException extends AppException {

    public DictionaryNotFoundException(String eid, String code) {
        super(eid, "DICTIONARY_NOT_FOUND", "Słownik o kodzie " + code + " nie został odnaleziony.");
    }

}

