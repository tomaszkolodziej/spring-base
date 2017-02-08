package com.tolean.elab.business.impl.dictionary;

import pl.wavesoftware.eid.exceptions.EidIllegalStateException;

/**
 * Created by tomasz.kolodziej@poczta.pl
 */
public class DictionaryNotFoundException extends EidIllegalStateException {

    public DictionaryNotFoundException(String eid, String code) {
        super(eid, "Słownik o kodzie " + code + " nie został odnaleziony.");
    }

}

