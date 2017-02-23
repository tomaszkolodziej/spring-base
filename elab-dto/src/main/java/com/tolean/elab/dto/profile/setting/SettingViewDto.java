package com.tolean.elab.dto.profile.setting;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

/**
 * Created by Tomasz Kołodziej
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SettingViewDto {

    private String name;
    private String description;
    private String groupName;
    private Object value;
    private Set<String> availableValues;

}
