package com.example.demoyamaha1.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContractDTO extends AbstractDTO<ContractDTO>{
    private String name;
    private String contractType;
    private String counterparty;
    private String transaction;
    private Date startDate;
    private Date expiredDate;
    private int automaticRenewal;
    private String pic;
    private String originalNum;
    private String fileLocation;
}
