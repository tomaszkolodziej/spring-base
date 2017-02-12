package com.tolean.elab.persistence.profile.setting;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

import static pl.wavesoftware.eid.utils.EidPreconditions.checkNotNull;

/**
 * Created by Tomasz Kołodziej
 */
@Repository
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SettingRepository {

    private final SettingBaseRepository settingBaseRepository;

    public Optional<Setting> findByProfileIdAndCode(Long profileId, String code) {
        checkNotNull(profileId, "20170212:193900");
        checkNotNull(code, "20170212:194200");

        return Optional.ofNullable(settingBaseRepository.findOneByProfileIdAndCode(profileId, code));
    }

    public Optional<Setting> findByProfileIdAndType(Long profileId, String type) {
        checkNotNull(profileId, "20170212:194300");
        checkNotNull(type, "20170212:194301");

        return Optional.ofNullable(settingBaseRepository.findOneByProfileIdAndType(profileId, type));
    }

    public Set<Setting> findAll(Long profileId) {
        checkNotNull(profileId, "20170212:195812");

        Set<Setting> settings = settingBaseRepository.findByProfileId(null);
        Set<Setting> profileSettings = settingBaseRepository.findByProfileId(profileId);

        settings.addAll(profileSettings);

        return settings;
    }

}
