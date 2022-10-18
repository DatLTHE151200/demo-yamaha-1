package com.example.demoyamaha1.entity;

import lombok.*;

import javax.persistence.*;

import static com.example.demoyamaha1.utils.VariableUtils.ID;
@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class BaseEntity<T> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = ID, nullable = false)
    private Long id;
}
