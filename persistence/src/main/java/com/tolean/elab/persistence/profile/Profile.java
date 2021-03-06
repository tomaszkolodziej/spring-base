package com.tolean.elab.persistence.profile;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by Tomasz Kołodziej
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "profile_gen")
    @SequenceGenerator(name = "profile_gen", sequenceName = "profile_id_seq")
    private Long id;

    private LocalDateTime createDate;
    private Integer createBy;
    private LocalDateTime updateDate;
    private Integer updateBy;
    private String login;
    private String password;
    private String name;
    private String firstName;
    private String lastName;
    private String email;
    private boolean active;

}



