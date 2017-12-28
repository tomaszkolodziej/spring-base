package com.tolean.elab.business.impl.profile;

import com.tolean.elab.business.impl.validation.ValidationError;
import com.tolean.elab.dto.profile.PasswordNewDto;
import com.tolean.elab.dto.profile.ProfileNewDto;
import com.tolean.elab.dto.profile.ProfileUpdateDto;
import org.springframework.stereotype.Component;

import static com.google.common.base.Preconditions.checkNotNull;
import static org.apache.commons.lang3.StringUtils.isBlank;

/**
 * Created by Tomasz Kołodziej
 */
@Component
public class ProfileValidator {

    private static final String LOGIN_FIELD = "login";
    private static final int LOGIN_MAX_LENGTH = 20;

    private static final String NAME_FIELD = "name";
    private static final int NAME_MAX_LENGTH = 20;

    public void checkNew(ProfileNewDto profileNewDto) {
        checkNotNull("20170125:090609", profileNewDto);

        ValidationError validationError = ValidationError.builder("20170226:211302");

        validateLogin(profileNewDto.getLogin(), validationError);

        validateName(NAME_FIELD, validationError);

        if (isBlank(profileNewDto.getEmail())) {
            validationError.fieldRequired("email");
        }

        validationError.throwExceptionIfHasErrorsOnFields();
    }

    public void checkUpdate(ProfileUpdateDto profileUpdateDto) {
        checkNotNull("20170221:090609", profileUpdateDto);

        ValidationError validationError = ValidationError.builder("20170226:210901");

        validateName(NAME_FIELD, validationError);

        if (isBlank(profileUpdateDto.getEmail())) {
            validationError.fieldRequired("email");
        }

        validationError.throwExceptionIfHasErrorsOnFields();
    }

    public void checkPassword(PasswordNewDto passwordNewDto) {
        checkNotNull("20170126:183500", passwordNewDto);

        ValidationError validationError = ValidationError.builder("20170126:1836");

        if (isBlank(passwordNewDto.getOldPassword())) {
            validationError.withCodeAndMessage("OLD_PASSWORD_NOT_PROVIDED", "Nie podano starego hasła.").throwException();
        }

        if (!passwordNewDto.getOldPassword().equals(passwordNewDto.getRepeatedNewPassword())) {
            validationError.withCodeAndMessage("NEW_AND_REPEATED_NEW_PASSWORD_NOT_MATCH", "Wpisano niepoprawnie nowe hasło.").throwException();
        }
    }

    private void validateLogin(String login, ValidationError validationError) {
        if (isBlank(login)) {
            validationError.fieldRequired(LOGIN_FIELD);
        }

        if (login.length() > LOGIN_MAX_LENGTH) {
            validationError.fieldMaxLength(LOGIN_FIELD, LOGIN_MAX_LENGTH);
        }
    }

    private void validateName(String name, ValidationError validationError) {
        if (isBlank(name)) {
            validationError.fieldRequired(NAME_FIELD);
        }

        if (name.length() > NAME_MAX_LENGTH) {
            validationError.fieldMaxLength(NAME_FIELD, NAME_MAX_LENGTH);
        }
    }

}
