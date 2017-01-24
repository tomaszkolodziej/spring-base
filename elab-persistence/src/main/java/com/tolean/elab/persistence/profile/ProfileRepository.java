package com.tolean.elab.persistence.profile;

import com.google.common.collect.Lists;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by Tomasz Kołodziej
 */
@Repository
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProfileRepository {

  private final ProfileBaseRepository profileBaseRepository;

  public Optional<Profile> findOne(Long id) {
    checkNotNull("20170114:1153", id);
    return Optional.of(profileBaseRepository.findOne(id));
  }

  public Optional<Profile> findByLogin(String login) {
    checkNotNull("20170114:1156", login);
    return Optional.of(profileBaseRepository.findByLogin(login));
  }

  public List<Profile> findAll() {
    return Lists.newArrayList(profileBaseRepository.findAll());
  }

}
