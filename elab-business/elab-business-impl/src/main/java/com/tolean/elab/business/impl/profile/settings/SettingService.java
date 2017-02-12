package com.tolean.elab.business.impl.profile.settings;

import com.tolean.elab.mapper.profile.settings.SettingMapper;
import com.tolean.elab.persistence.profile.Profile;
import com.tolean.elab.persistence.profile.setting.Setting;
import com.tolean.elab.persistence.profile.setting.SettingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.wavesoftware.eid.exceptions.EidIllegalStateException;

import java.util.Set;
import java.util.function.Supplier;

import static pl.wavesoftware.eid.utils.EidPreconditions.checkNotNull;

/**
 * Created by Tomasz Kołodziej
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SettingService {

    private final SettingRepository settingRepository;
    private final SettingMapper settingMapper;

    public Set<Setting> getSettings(Long profileId) {
        checkNotNull(profileId, "20170212:195802");

        return settingRepository.findAll(profileId);
    }

    public Setting getSetting(Long profileId, String code) {
        checkNotNull(profileId, "20170212:195923");
        checkNotNull(code, "20170212:192001");

        return settingRepository.findByProfileIdAndCode(profileId, code)
                .orElseThrow(settingNotFoundException(code));
    }

    public <T> T getSettingValue(Class<T> clazz) {
        checkNotNull(clazz, "20170212:193401");

        Setting setting = settingRepository.findByProfileIdAndType(getCurrentProfile().getId(), clazz.getName())
                .orElseThrow(settingNotFoundException(clazz.getName()));
        return clazz.cast(setting.getValue());
    }

    private Profile getCurrentProfile() {
        // TODO wczytac informacje o zalogowanym uzytkowniku
        return Profile.builder().id(1L).build();
    }

    private Supplier settingNotFoundException(String identifier) {
        return () -> new EidIllegalStateException("20170212:194500", "Parametr o identyfikatorze " + identifier + " nie został odnaleziony.");
    }

}
