package com.example.demoyamaha1.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

import static com.example.demoyamaha1.utils.VariableUtils.*;

@Entity
@Table(name = TABLE_TICKET_LEGAL)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TicketLegal extends BaseEntity<TicketLegal> implements Serializable {

    private static final long serialVersionUID = 3036289331942807647L;

    @Column(name = TICKET_ID)
    private int ticketId;

    @Column(name = TICKET_PIC)
    private String pic;

    @Column(name = TICKET_DATE)
    private Date date;

    @Column(name = TICKET_ONTIME)
    private int ontime;

    @Column(name = TICKET_CHECK)
    private int check;

    @Column(name = TICKET_APPROVED)
    private int approved;

    @Column(name = TICKET_STATUS)
    private int status;
}
