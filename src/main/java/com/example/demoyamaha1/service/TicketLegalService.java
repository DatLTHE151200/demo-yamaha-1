package com.example.demoyamaha1.service;

import com.example.demoyamaha1.dto.ReportContractDTO;
import com.example.demoyamaha1.dto.TicketLegalDTO;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;

public interface TicketLegalService {
    List<TicketLegalDTO> searchTicketLegal(Date from, Date to, Pageable pageable);
    List<TicketLegalDTO> searchTicketLegal(Date from, Date to);
    List<ReportContractDTO> ReportContractLegalByDate(Date from, Date to);
}
