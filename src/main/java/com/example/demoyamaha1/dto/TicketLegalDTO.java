package com.example.demoyamaha1.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TicketLegalDTO extends AbstractDTO<TicketLegalDTO> {
    private int ticketId;
    private String pic;
    private Date date;
    private int ontime;
    private int check;
    private int approved;
    private int status;
}

