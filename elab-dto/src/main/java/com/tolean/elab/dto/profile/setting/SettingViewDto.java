package com.tolean.elab.dto.profile.setting;

import lombok.Data;

import java.util.List;

/**
 * Created by Tomasz Kołodziej
 */
@Data
public class SettingViewDto {

    private String code;
    private List<String> valueList;
    private String value;
    private boolean list;

}
