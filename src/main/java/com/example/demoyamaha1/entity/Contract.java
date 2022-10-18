package com.example.demoyamaha1.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

import static com.example.demoyamaha1.utils.VariableUtils.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = TABLE_CONTRACT)
public class Contract extends BaseEntity<Contract>{
    @Column(name = CONTRACT_NAME)
    private String name;

    @Column(name = CONTRACT_TYPE)
    private String contractType;

    @Column(name = CONTRACT_COUNTERPARTY)
    private String counterparty;

    @Column(name = CONTRACT_TRANSACTION)
    private String transaction;

    @Column(name = CONTRACT_START_DATE)
    private Date startDate;

    @Column(name = CONTRACT_EXPIRED_DATE)
    private Date expiredDate;

    @Column(name = CONTRACT_AUTOMATIC_RENEWAL)
    private int automaticRenewal;

    @Column(name = CONTRACT_PIC)
    private String pic;

    @Column(name = CONTRACT_ORIGINAL_NUM)
    private String originalNum;

    @Column(name = CONTRACT_FILE_LOCATION)
    private String fileLocation;
}
