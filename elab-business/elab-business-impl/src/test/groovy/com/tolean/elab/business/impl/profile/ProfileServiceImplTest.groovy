package com.tolean.elab.business.impl.profile

import com.tolean.elab.business.api.profile.ProfileService
import com.tolean.elab.business.impl.profile.action.ProfileChangePasswordAction
import com.tolean.elab.business.impl.profile.settings.SettingService
import com.tolean.elab.dto.profile.PasswordNewDto
import com.tolean.elab.mapper.profile.ProfileMapper
import com.tolean.elab.mapper.profile.settings.SettingMapper
import com.tolean.elab.persistence.profile.Profile
import com.tolean.elab.persistence.profile.ProfileRepository
import spock.lang.Specification
/**
 * Created by tomasz.kolodziej@poczta.pl
 */
class ProfileServiceImplTest extends Specification {

    SettingService settingServiceMock
    ProfileRepository profileRepositoryMock
    ProfileChangePasswordAction profileChangePasswordActionMock
    ProfileMapper profileMapperMock
    SettingMapper settingMapperMock
    ProfileValidator profileValidatorMock
    ProfileService profileService

    def setup() {
        settingServiceMock = Mock(SettingService)
        profileRepositoryMock = Mock(ProfileRepository)
        profileChangePasswordActionMock = Mock(ProfileChangePasswordAction)
        profileMapperMock = Mock(ProfileMapper)
        settingMapperMock = Mock(SettingMapper)
        profileValidatorMock = Mock(ProfileValidator)
        profileService = new ProfileServiceImpl(settingServiceMock, profileRepositoryMock, profileChangePasswordActionMock,
                profileMapperMock, settingMapperMock, profileValidatorMock)
    }

    def "getProfiles should not throw any exception"() {
        when:
            profileService.getProfiles()
        then:
            1 * profileMapperMock.toProfileLightViewDtos(_)
    }

    def "getProfile by id should throw exception if profile with given id not found"() {
        given:
            long PROFILE_ID_NOT_EXIST = 999L
            profileRepositoryMock.findOne(PROFILE_ID_NOT_EXIST) >> Optional.empty()
        when:
            profileService.getProfile(PROFILE_ID_NOT_EXIST)
        then:
            thrown(ProfileNotFoundException)
    }

    def "getProfile by id should return profile if exist"() {
        given:
            profileRepositoryMock.findOne(_) >> Optional.of(Profile.builder().build())
        when:
            profileService.getProfile(1L)
        then:
            1 * profileMapperMock.toProfileViewDto(_)
    }

    def "getProfile by login should throw exception if profile with given login not found"() {
        given:
            String LOGIN_NOT_EXIST = "login which not exist"
            profileRepositoryMock.findByLogin(LOGIN_NOT_EXIST) >> Optional.empty()
        when:
            profileService.getProfile(LOGIN_NOT_EXIST)
        then:
            thrown(ProfileNotFoundException)
    }

    def "getProfile by login should return profile if profile with given login exist"() {
        given:
            profileRepositoryMock.findByLogin(_) >> Optional.of(Profile.builder().build())
        when:
            profileService.getProfile("login exist")
        then:
            1 * profileMapperMock.toProfileViewDto(_)
    }

    def "should properly change password"() {
        given:
            Profile profile = Profile.builder().id(1L).build()

            profileRepositoryMock.findOne(profile.id) >> Optional.of(profile)

            PasswordNewDto passwordNewDto = new PasswordNewDto()
            passwordNewDto.oldPassword = "old pass"
            passwordNewDto.newPassword = "new pass"
            passwordNewDto.repeatedNewPassword = passwordNewDto.newPassword

            profileChangePasswordActionMock.change(profile, passwordNewDto) >> profile
        when:
            profileService.changePassword(profile.id, passwordNewDto)
        then:
            1 * profileChangePasswordActionMock.change(profile, passwordNewDto)
    }

}
