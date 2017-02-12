package com.tolean.elab.dto.profile.settings;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Tomasz Kołodziej
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SettingViewDto {

    private String code;
    private String name;
    private String description;
    private String groupName;
    private boolean onlyAdministratorCanChange;
    private Object value;

}
