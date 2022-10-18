package com.example.demoyamaha1.service.impl;

import com.example.demoyamaha1.dto.ReportRegularDTO;
import com.example.demoyamaha1.repository.TicketRepository;
import com.example.demoyamaha1.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.commons.lang3.StringUtils;
import javax.persistence.Tuple;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private TicketRepository ticketRepository;

    @Override
    public List<ReportRegularDTO> findReportRegularByDate(Date from, Date to) {
        List<Tuple> list = ticketRepository.findReportRegularByDate(from, to);
        List<ReportRegularDTO> result = new ArrayList<>();
        for (Tuple item : list){
            result.add(
                   new ReportRegularDTO(
                           ((BigInteger)item.get(0)).intValue(),
                           (String)item.get(1),
                           StringUtils.strip((String)item.get(2)+"_"+(String)item.get(3)+"_"+(String)item.get(4),"_"),
                           (Date)item.get(5),
                           (String)item.get(6),
                           (Date)item.get(7),
                           (Date)item.get(8),
                           (String)item.get(9),
                           (String)item.get(10),
                           (int)item.get(11),
                           (boolean)item.get(12),
                           ((BigInteger)item.get(13)).intValue(),
                           (String)item.get(14),
                           (int)item.get(15),
                           (boolean)item.get(16),
                           ((BigInteger)item.get(17)).intValue(),
                           (int)item.get(18)
                   )
            );
        }
        return result;
    }
}
