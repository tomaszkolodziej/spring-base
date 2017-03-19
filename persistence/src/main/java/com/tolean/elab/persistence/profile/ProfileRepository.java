package com.tolean.elab.persistence.profile;

import com.google.common.collect.Sets;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

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

        return Optional.ofNullable(profileBaseRepository.findOne(id));
    }

    public Optional<Profile> findByLogin(String login) {
        checkNotNull("20170114:1156", login);

        return Optional.ofNullable(profileBaseRepository.findByLogin(login));
    }

    public Set<Profile> findAll() {
        return Sets.newHashSet(profileBaseRepository.findAll());
    }

    public Profile save(Profile profile) {
        checkNotNull("2017012600", profile);

        return profileBaseRepository.save(profile);
    }

}
