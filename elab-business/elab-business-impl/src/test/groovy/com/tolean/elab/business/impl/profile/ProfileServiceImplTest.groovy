package com.tolean.elab.business.impl.profile

import com.tolean.elab.business.api.profile.ProfileService
import com.tolean.elab.mapper.profile.ProfileMapper
import com.tolean.elab.persistence.profile.Profile
import com.tolean.elab.persistence.profile.ProfileRepository
import spock.lang.Specification

/**
 * Created by tomasz.kolodziej@poczta.pl
 */
class ProfileServiceImplTest extends Specification {

  ProfileRepository profileRepositoryMock
  ProfileMapper profileMapperMock
  ProfileService profileService

  def setup() {
    profileRepositoryMock = Mock()
    profileMapperMock = Mock()
    profileService = new ProfileServiceImpl(profileRepositoryMock, profileMapperMock)
  }

  def "getProfiles should not throw any exception"() {
    when:
      profileService.getProfiles()
    then:
      1 * profileMapperMock.toProfileViewDtoList(_)
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

}
