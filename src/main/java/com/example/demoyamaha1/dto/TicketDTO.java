package com.example.demoyamaha1.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TicketDTO extends AbstractDTO<TicketDTO>{
    private int contractId;
    private Date assignDate;
    private Date completeDate;
    private String pendingAt;
    private Date scanSubmitted;
}
