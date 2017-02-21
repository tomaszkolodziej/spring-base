package com.tolean.elab.business.impl.profile.action

import com.tolean.elab.business.impl.profile.ProfileValidator
import com.tolean.elab.dto.profile.PasswordNewDto
import com.tolean.elab.persistence.profile.Profile
import spock.lang.Specification

/**
 * Created by Tomasz Kołodziej
 */
class ProfileChangePasswordActionTest extends Specification {

    ProfileValidator profileValidator
    ProfileChangePasswordAction profileChangePasswordAction

    def setup() {
        profileValidator = Mock(ProfileValidator)
        profileChangePasswordAction = new ProfileChangePasswordAction(profileValidator)
    }

    def "should encode password"() {
        given:
            PasswordNewDto passwordNewDto = PasswordNewDto.builder().oldPassword("test").newPassword("haslo").build();
        when:
            Profile profile = profileChangePasswordAction.change(new Profile(), passwordNewDto)
        then:
            profile.password != passwordNewDto.oldPassword
            profile.password != passwordNewDto.newPassword
    }

}
