package com.example.demoyamaha1.service;

import com.example.demoyamaha1.dto.ReportRegularDTO;

import java.util.Date;
import java.util.List;

public interface ReportService {
    List<ReportRegularDTO> findReportRegularByDate(Date from, Date to);
}
