package com.tolean.elab.persistence.profile;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date createDate;
    private Integer createBy;
    private Date updateDate;
    private Integer updateBy;
    private String login;
    private String password;
    private String name;
    private String firstName;
    private String lastName;
    private String email;
    private boolean active;

}



