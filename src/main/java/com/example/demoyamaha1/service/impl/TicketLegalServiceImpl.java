package com.example.demoyamaha1.service.impl;

import com.example.demoyamaha1.dto.ReportContractDTO;
import com.example.demoyamaha1.dto.TicketLegalDTO;
import com.example.demoyamaha1.entity.TicketLegal;
import com.example.demoyamaha1.repository.TicketLegalRepository;
import com.example.demoyamaha1.service.TicketLegalService;
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
public class TicketLegalServiceImpl implements TicketLegalService {

    private static final Logger logger = LoggerFactory.getLogger(TicketLegalServiceImpl.class);
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private TicketLegalRepository ticketLegalRepository;

    @Override
    public List<TicketLegalDTO> searchTicketLegal(Date from, Date to, Pageable pageable) {
        List<TicketLegalDTO> results = new ArrayList<>();
        return null;
    }

    @Override
    public List<TicketLegalDTO> searchTicketLegal(Date from, Date to) {
        List<TicketLegal> entities = ticketLegalRepository.findAllByDateBetween(from, to);
        return entities.stream().map(ticketLegal -> modelMapper
                .map(ticketLegal, TicketLegalDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<ReportContractDTO> ReportContractLegalByDate(Date from, Date to) {
        List<Tuple> list = new ArrayList<>();
        List<ReportContractDTO> result = new ArrayList<>();
        list.add(ticketLegalRepository.ReportContractLegalTotalByDate(from, to));
        list.addAll(ticketLegalRepository.ReportContractLegalByDate(from, to));
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
