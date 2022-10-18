package com.example.demoyamaha1.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import static com.example.demoyamaha1.utils.VariableUtils.*;

@Entity
@Table(name = TABLE_ROLES)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Role extends BaseEntity<Role>{

    @Column(name = ROLE_NAME)
    private String name;

    @Column(name = ROLE_PERMISSION_LEVEL)
    private int permission_level;

    @Column(name = ROLE_DESCRIPTION)
    private String description;


}
