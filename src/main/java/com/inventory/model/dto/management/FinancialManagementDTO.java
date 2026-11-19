package com.inventory.model.dto.management;

import java.sql.Date;

import com.inventory.model.management.Expense;

import lombok.Data;

@Data 
public class FinancialManagementDTO {
    private Long id;
    private Expense expense;
    private String productCode;
    private String description;
    private String enterprise;
    private String cpnj;
    private String supplierCode;
    private String requestNumber;
    private Float value;
    private Date changeDate;
    private String userChange; 
}
