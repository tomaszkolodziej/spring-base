package com.tolean.elab.persistence.profile.setting;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by Tomasz Kołodziej
 */
@Document(collection = "settings")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Setting<V> {

    @Id
    private String id;
    private Long profileId;
    private SettingType type;
    private Parameter<V> parameter;

}
