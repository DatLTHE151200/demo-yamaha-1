package com.example.demoyamaha1.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReportRegularDTO {
    private int id;
    private String ed;
    private String subject;
    private Date assignDate;
    private String pendingAt;
    private Date completeDate;
    private Date scanSubmitted;
    private String edPic;

    private String legalPic;
    private int legalStatus;
    private boolean legalApproval;
    private int countLegalCheck;

    private String acctPic;
    private int acctStatus;
    private boolean acctApproval;
    private int countACCTCheck;

    private int countEdEdit;
}
