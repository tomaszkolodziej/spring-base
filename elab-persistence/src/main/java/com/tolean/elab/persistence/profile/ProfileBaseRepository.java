package com.tolean.elab.persistence.profile;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by tomasz.kolodziej@poczta.pl
 */
@Repository
public interface ProfileBaseRepository extends CrudRepository<Profile, Long> {

  Profile findByLogin(String login);

}
