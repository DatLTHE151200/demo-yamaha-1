package com.example.demoyamaha1.service;

import com.example.demoyamaha1.dto.ReportContractDTO;
import com.example.demoyamaha1.dto.TicketACCTDTO;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;
public interface TicketACCTService {
    List<TicketACCTDTO> searchTicketACCT(Date from, Date to, Pageable pageable);
    List<TicketACCTDTO> searchTicketACCT(Date from, Date to);
    List<ReportContractDTO> ReportContractACCTByDate(Date from, Date to);
}
