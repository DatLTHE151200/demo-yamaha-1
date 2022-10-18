package com.example.demoyamaha1.service;

import com.example.demoyamaha1.dto.EDReportDTO;

import java.util.Date;
import java.util.List;
//@Service
public interface EDReportService {
    List<EDReportDTO> findEDReportByDate(Date from, Date to);
}
