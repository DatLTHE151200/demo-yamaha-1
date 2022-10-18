package com.example.demoyamaha1.controller.report;

import com.example.demoyamaha1.api.output.EDReport;
import com.example.demoyamaha1.dto.ReportContractDTO;
import com.example.demoyamaha1.service.TicketACCTService;
import com.example.demoyamaha1.service.impl.TicketLegalServiceImpl;
import org.modelmapper.ModelMapper;
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
@RequestMapping("api/TicketACCT/report")
public class ACCTReportController {
    private static final Logger logger = LoggerFactory.getLogger(TicketLegalServiceImpl.class);
    private final SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT_YYYY_MM_DD);

    @Autowired
    private TicketACCTService TicketACCTService;
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/search")
    public EDReport searchStatisticTicketLegal(
            @RequestParam(name = "from", required = false, defaultValue = "0000-01-01") String from,
            @RequestParam(name = "to", required = false, defaultValue = "9999-12-31") String to){
        EDReport result = new EDReport();
        try {
            Date fromDate = dateFormat.parse(from);
            Date toDate = dateFormat.parse(to);
            List<ReportContractDTO> resultList = TicketACCTService.ReportContractACCTByDate(fromDate, toDate);
            result.setListResult(resultList);
            return result;
        }catch (Exception ex){
            logger.error(ex.getMessage());
            return null;
        }
    }
}
