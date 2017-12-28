package com.tolean.elab.business.impl.profile;

import com.tolean.elab.commons.AppException;

/**
 * Created by tomasz.kolodziej@poczta.pl
 */
public class ProfileNotFoundException extends AppException{

    private static final String PROFILE_NOT_FOUND = "PROFILE_NOT_FOUND";

    public ProfileNotFoundException(String eid, Long profileId) {
        super(eid, PROFILE_NOT_FOUND, "Profil o id " + profileId + " nie został odnaleziony.");
    }

    public ProfileNotFoundException(String eid, String login) {
        super(eid, PROFILE_NOT_FOUND, "Profil o loginie " + login + " nie został odnaleziony.");
    }

}
