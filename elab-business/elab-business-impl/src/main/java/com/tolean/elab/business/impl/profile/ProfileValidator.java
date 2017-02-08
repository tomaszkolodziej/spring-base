package com.tolean.elab.business.impl.profile;

import com.tolean.elab.business.impl.validation.ValidationError;
import com.tolean.elab.dto.profile.PasswordNewDto;
import com.tolean.elab.persistence.profile.Profile;
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

    public void check(Profile profile) {
        checkNotNull("20170125:0906", profile);

        ValidationError validationError = ValidationError.builder()
                .id("20170125:0922")
                .standardValidationError()
                .fields();

        validateLogin(profile.getLogin(), validationError);

        validateName(NAME_FIELD, validationError);

        if (isBlank(profile.getEmail())) {
            validationError.required("email");
        }

        validationError.throwExceptionIfHasErrorsOnFields();
    }

    public void checkPassword(PasswordNewDto passwordNewDto) {
        checkNotNull("20170126:1835", passwordNewDto);

        ValidationError validationError = ValidationError.builder().id("20170126:1836");

        if (isBlank(passwordNewDto.getOldPassword())) {
            validationError.message("Nie podano starego hasła.").throwException();
        }

        if (!passwordNewDto.getOldPassword().equals(passwordNewDto.getRepeatedNewPassword())) {
            validationError.message("Wpisano niepoprawnie nowe hasło.").throwException();
        }
    }

    private void validateLogin(String login, ValidationError validationError) {
        if (isBlank(login)) {
            validationError.required(LOGIN_FIELD);
        }

        if (login.length() > LOGIN_MAX_LENGTH) {
            validationError.maxLength(LOGIN_FIELD, LOGIN_MAX_LENGTH);
        }
    }

    private void validateName(String name, ValidationError validationError) {
        if (isBlank(name)) {
            validationError.required(NAME_FIELD);
        }

        if (name.length() > NAME_MAX_LENGTH) {
            validationError.maxLength(NAME_FIELD, NAME_MAX_LENGTH);
        }
    }

}
