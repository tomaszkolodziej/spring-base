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
@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Setting {

    @Id
    private String id;

    private Long profileId;
    private String code;
    private String name;
    private String description;
    private Group group;
    private String type;
    private boolean onlyAdministratorCanChange;
    private SettingValue defaultValue;
    private SettingValue value;

}
