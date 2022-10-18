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
public class Ticket extends BaseEntity<Ticket>{

    @Column(name = TICKET_FK_CONTRACT_ID)
    private int contractId;

    @Column(name = TICKET_ASSIGN_DATE)
    private Date assignDate;

    @Column(name = TICKET_COMPLETE_DATE)
    private Date completeDate;

    @Column(name = TICKET_PENDING_AT)
    private String pendingAt;

    @Column(name = TICKET_SCAN_SUBMITTED)
    private Date scanSubmitted;
}
