package com.example.demoyamaha1.service.impl;

import com.example.demoyamaha1.dto.ReportContractDTO;
import com.example.demoyamaha1.dto.TicketACCTDTO;
import com.example.demoyamaha1.entity.TicketACCT;
import com.example.demoyamaha1.repository.TicketACCTRepository;
import com.example.demoyamaha1.service.TicketACCTService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.Tuple;
import javax.transaction.Transactional;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class TicketACCTServiceImpl implements TicketACCTService {

    private static final Logger logger = LoggerFactory.getLogger(TicketLegalServiceImpl.class);
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private TicketACCTRepository ticketACCTRepository;

    @Override
    public List<TicketACCTDTO> searchTicketACCT(Date from, Date to, Pageable pageable) {
        return null;
    }

    @Override
    public List<TicketACCTDTO> searchTicketACCT(Date from, Date to) {
        List<TicketACCT> entities = ticketACCTRepository.findAllByDateBetween(from, to);
        return entities.stream().map(ticketACCT -> modelMapper
                .map(ticketACCT, TicketACCTDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<ReportContractDTO> ReportContractACCTByDate(Date from, Date to) {
        List<Tuple> list = new ArrayList<>();
        List<ReportContractDTO> result = new ArrayList<>();
        list.add(ticketACCTRepository.ReportTicketACCTTotalByDate(from, to));
        list.addAll(ticketACCTRepository.ReportTicketACCTByDate(from, to));
        for (Tuple item: list) {
            result.add(
                    new ReportContractDTO(
                            (String)item.get(0),
                            ((BigInteger)item.get(1)).intValue(),
                            ((BigInteger)item.get(2)).intValue(),
                            ((BigInteger)item.get(3)).intValue(),
                            ((BigInteger)item.get(4)).intValue(),
                            ((BigInteger)item.get(5)).intValue(),
                            ((BigInteger)item.get(6)).intValue(),
                            ((BigInteger)item.get(7)).intValue(),
                            ((BigInteger)item.get(8)).intValue()
                    )
            );
        }
        return result;
    }
}
