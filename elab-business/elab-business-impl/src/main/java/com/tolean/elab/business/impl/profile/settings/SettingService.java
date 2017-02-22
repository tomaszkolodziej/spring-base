package com.tolean.elab.business.impl.profile.settings;

import com.tolean.elab.mapper.profile.settings.SettingMapper;
import com.tolean.elab.persistence.profile.Profile;
import com.tolean.elab.persistence.profile.setting.Setting;
import com.tolean.elab.persistence.profile.setting.SettingType;
import com.tolean.elab.persistence.profile.setting.SettingRepository;
import com.tolean.elab.persistence.profile.setting.value.SettingValue;
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

        SettingType settingType = SettingType.valueOf(code);

        return settingRepository.findByProfileIdAndType(profileId, settingType)
                .orElseThrow(settingNotFoundException(code));
    }

    public <V, T extends SettingValue<V>> T getSettingValue(Class<T> clazz, SettingType type) {
        checkNotNull(clazz, "20170212:193401");
        checkNotNull(type, "20170219:161800");

        Setting setting = settingRepository.findByProfileIdAndType(getCurrentProfile().getId(), type)
                .orElseThrow(settingNotFoundException(clazz.getName()));
        return clazz.cast(setting.getSettingValue());
    }

    private Profile getCurrentProfile() {
        // TODO wczytac informacje o zalogowanym uzytkowniku
        return Profile.builder().id(1L).build();
    }

    private Supplier settingNotFoundException(String identifier) {
        return () -> new EidIllegalStateException("20170212:194500", "Parametr o identyfikatorze " + identifier + " nie został odnaleziony.");
    }

}
