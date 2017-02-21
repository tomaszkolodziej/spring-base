package com.tolean.elab.business.impl.dictionary;

import pl.wavesoftware.eid.exceptions.EidIllegalStateException;

/**
 * @author Bartosz Olszanski <bartosz.olszanski@coi.gov.pl>
 */
public class DictionaryItemNotFoundException extends EidIllegalStateException {

    public DictionaryItemNotFoundException(String eid, String value) {
      super(eid, "Wartość słownika " + value + " nie została odnaleziona.");
    }
}
