package com.example.demoyamaha1.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReportContractDTO {
    private String pic;
    private int checkedOntime;
    private int checkedOverdue;
    private int uncheckedOntime;
    private int uncheckedOverdue;
    private int pendingOntime;
    private int pendingOverdue;
    private int finishedOntime;
    private int finishedOverdue;
}
