package com.example.demoyamaha1.controller.report;

import com.example.demoyamaha1.dto.EDReportDTO;
import com.example.demoyamaha1.service.EDReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static com.example.demoyamaha1.utils.WebConstants.DATE_FORMAT_YYYY_MM_DD;

@CrossOrigin("*")
@RestController
@RequestMapping("api/EDReport")
public class EDReportController {
    private final SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT_YYYY_MM_DD);

    @Autowired
    private EDReportService EDReportService;

    @GetMapping("/search")
    public List<EDReportDTO> reportByDate(
            @RequestParam(name = "from", required = false, defaultValue = "0000-01-01") String from,
            @RequestParam(name = "to", required = false, defaultValue = "9999-12-31") String to){
        try {
            Date fromDate = dateFormat.parse(from);
            Date toDate = dateFormat.parse(to);
            return EDReportService.findEDReportByDate(fromDate, toDate);
        }catch (Exception ex){
            return null;
        }
    }
}
