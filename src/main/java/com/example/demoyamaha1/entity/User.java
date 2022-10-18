package com.example.demoyamaha1.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

import static com.example.demoyamaha1.utils.VariableUtils.*;

@Entity
@Table(name = TABLE_USER)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity<User> implements Serializable {

    private static final long serialVersionUID = 3036289331942807647L;

    @Column(name = USER_USERNAME)
    private String username;

    @Column(name = USER_PASSWORD)
    private String password;

    @Column(name = USER_EMAIL)
    private String email;

    @Column(name = USER_STATUS)
    private int status;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = TABLE_USER_ROLE,
            joinColumns = {@JoinColumn(name = USER_ROLE_USER_ID)},
            inverseJoinColumns = {@JoinColumn(name = USER_ROLE_ROLE_ID)})
    private Set<Role> roles;
}
