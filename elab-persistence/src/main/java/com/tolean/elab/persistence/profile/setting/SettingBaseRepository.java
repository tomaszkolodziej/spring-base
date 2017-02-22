package com.tolean.elab.persistence.profile.setting;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

/**
 * Created by Tomasz Kołodziej
 */
@Repository
public interface SettingBaseRepository extends MongoRepository<Setting, String> {

    Set<Setting> findByProfileIdIsNull();

    Set<Setting> findByProfileId(Long profileId);

    Setting findOneByProfileIdAndType(Long profileId, String type);

}
