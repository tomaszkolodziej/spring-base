package com.tolean.elab.business.impl.profile;

import pl.wavesoftware.eid.exceptions.EidIllegalStateException;

/**
 * Created by tomasz.kolodziej@poczta.pl
 */
public class ProfileNotFoundException extends EidIllegalStateException {

    public ProfileNotFoundException(String eid, Long profileId) {
        super(eid, "Profil o id " + profileId + " nie został odnaleziony.");
    }

    public ProfileNotFoundException(String eid, String login) {
        super(eid, "Profil o loginie " + login + " nie został odnaleziony.");
    }

}
