package com.tolean.elab.persistence.profile.setting;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Tomasz Kołodziej
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Group {

    private String name;
    private int order;

    public static Group dateAndTimeGroup() {
        return new Group("Data i czas", 100);
    }

    public static Group otherGroup() {
        return new Group("Inne", 1000);
    }

}
