package com.example.demoyamaha1.controller.ticket;

import com.example.demoyamaha1.api.output.TicketLegalOutput;
import com.example.demoyamaha1.service.TicketLegalService;
import com.example.demoyamaha1.service.impl.TicketLegalServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.slf4j.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import static com.example.demoyamaha1.utils.WebConstants.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/TicketLegal")
public class TicketLegalManagementController {

    private static final Logger logger = LoggerFactory.getLogger(TicketLegalServiceImpl.class);
    private final SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT_YYYY_MM_DD);

    @Autowired
    private TicketLegalService TicketLegalService;

    @GetMapping("/search")
    public TicketLegalOutput searchTicketLegal(
            @RequestParam(name = "from", required = false, defaultValue = "0000-01-01") String from,
            @RequestParam(name = "to", required = false, defaultValue = "9999-12-31") String to){
        TicketLegalOutput result = new TicketLegalOutput();
        try {
            Date fromDate = dateFormat.parse(from);
            Date toDate = dateFormat.parse(to);
            result.setListResult(TicketLegalService.searchTicketLegal(fromDate, toDate));
            return result;
        }catch (Exception ex){
            logger.error(ex.getMessage());
            return null;
        }
    }
}
