package com.example.demoyamaha1.controller.ticket;

import com.example.demoyamaha1.api.output.TicketACCTOutput;
import com.example.demoyamaha1.service.TicketACCTService;
import com.example.demoyamaha1.service.impl.TicketACCTServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import static com.example.demoyamaha1.utils.WebConstants.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/TicketACCT")
public class TicketACCTManagementController {
    private static final Logger logger = LoggerFactory.getLogger(TicketACCTServiceImpl.class);
    private final SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT_YYYY_MM_DD);

    @Autowired
    private TicketACCTService TicketACCTService;

    @GetMapping("/search")
    public TicketACCTOutput searchTicketACCT(
            @RequestParam(name = "from", required = false, defaultValue = "0000-01-01") String from,
            @RequestParam(name = "to", required = false, defaultValue = "9999-12-31") String to){
        TicketACCTOutput result = new TicketACCTOutput();
        try {
            Date fromDate = dateFormat.parse(from);
            Date toDate = dateFormat.parse(to);
            result.setListResult(TicketACCTService.searchTicketACCT(fromDate, toDate));
            return result;
        }catch (Exception ex){
            logger.error(ex.getMessage());
            return null;
        }
    }
}
