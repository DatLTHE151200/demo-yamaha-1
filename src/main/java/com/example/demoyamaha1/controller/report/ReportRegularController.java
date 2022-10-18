package com.example.demoyamaha1.controller.report;

import com.example.demoyamaha1.api.output.ReportRegularOutput;
import com.example.demoyamaha1.dto.ReportRegularDTO;
import com.example.demoyamaha1.service.ReportService;
import com.example.demoyamaha1.service.impl.TicketLegalServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static com.example.demoyamaha1.utils.WebConstants.DATE_FORMAT_YYYY_MM_DD;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/report/regular-report")
public class ReportRegularController {

    @Autowired
    private ReportService reportService;

    private static final Logger logger = LoggerFactory.getLogger(TicketLegalServiceImpl.class);
    private final SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT_YYYY_MM_DD);

    @GetMapping("/search")
    public ReportRegularOutput searchRegularReportByDate(
            @RequestParam(name = "from", required = false, defaultValue = "0000-01-01") String from,
            @RequestParam(name = "to", required = false, defaultValue = "9999-12-31") String to){
        ReportRegularOutput result = new ReportRegularOutput();
        try {
            Date fromDate = dateFormat.parse(from);
            Date toDate = dateFormat.parse(to);
            List<ReportRegularDTO> resultList = reportService.findReportRegularByDate(fromDate, toDate);
            result.setListResult(resultList);
            return result;
        }catch (Exception ex){
            logger.error(ex.getMessage());
            return null;
        }
    }
}
