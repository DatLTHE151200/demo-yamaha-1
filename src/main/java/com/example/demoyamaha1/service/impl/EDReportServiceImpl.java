package com.example.demoyamaha1.service.impl;

import com.example.demoyamaha1.dto.EDReportDTO;
import com.example.demoyamaha1.repository.TicketACCTRepository;
import com.example.demoyamaha1.repository.TicketLegalRepository;
import com.example.demoyamaha1.service.EDReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class EDReportServiceImpl implements EDReportService {
    @Autowired
    private TicketACCTRepository ticketACCTRepository;
    @Autowired
    private TicketLegalRepository ticketLegalRepository;

    @Override
    public List<EDReportDTO> findEDReportByDate(Date from, Date to) {
        List<EDReportDTO> result= new ArrayList<>();
        result.add(new EDReportDTO("I. Total Contracts",
                ticketACCTRepository.findAllByDateBetween(from,to).size()+
                        ticketLegalRepository.findAllByDateBetween(from,to).size(),""));
        result.add(new EDReportDTO("II. Total contracts with legal check",
                ticketLegalRepository.findAllByCheckAndDateBetween(1,from,to).size(),""));
        result.add(new EDReportDTO("III. Total contracts with no legal check",
                ticketLegalRepository.findAllByCheckAndDateBetween(0,from,to).size(),""));
        result.add(new EDReportDTO("IV. Total contracts with ACCT check",
                ticketACCTRepository.findAllByCheckAndDateBetween(1,from,to).size(),""));
        result.add(new EDReportDTO("V. Total contracts with no ACCT check",
                ticketACCTRepository.findAllByCheckAndDateBetween(0,from,to).size(),""));
        result.add(new EDReportDTO("VI. Number of completed contract ",
                ticketLegalRepository.findAllByStatusAndDateBetween(1,from,to).size()+
                        ticketACCTRepository.findAllByStatusAndDateBetween(1,from,to).size(),""));
        result.add(new EDReportDTO("VII. Number of pending contracts",
                ticketLegalRepository.findAllByStatusAndDateBetween(0,from,to).size()+
                        ticketACCTRepository.findAllByStatusAndDateBetween(0,from,to).size(),""));
        return result;
    }
}
