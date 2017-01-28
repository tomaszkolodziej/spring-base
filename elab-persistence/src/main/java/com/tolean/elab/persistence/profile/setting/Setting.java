package com.tolean.elab.persistence.profile.setting;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Created by Tomasz Kołodziej
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Setting {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "setting_gen")
    @SequenceGenerator(name = "setting_gen", sequenceName = "setting_id_seq")
    private Long id;
    private String code;
    private String name;
    private String description;

    @Enumerated(EnumType.STRING)
    private ValueType valueType;

    private String value;

}
