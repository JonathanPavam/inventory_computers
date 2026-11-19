package com.inventory.model.management;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity 
@Table (name = "financial_management")
@Data 
public class FinancialManagement {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column (name="expense", nullable = false, length = 80)
    private Expense expense;
    
    @Column (name="product_code", nullable = false, length = 80)
    private String productCode;
    
    @Column (name="description", nullable = false, length = 80)
    private String description;
    
    @Column (name="enterprise", nullable = false, length = 80)
    private String enterprise;
    
    @Column (name="cpnj", nullable = false, length = 80)
    private String cpnj;
    
    @Column (name="supplier_code", nullable = false, length = 80)
    private String supplierCode;
    
    @Column (name="requestNumber", nullable = false, length = 80)
    private String requestNumber;
    
    @Column (name="value", nullable = false)
    private Float value;
    
    @Column (name = "change_date")
    private Date changeDate;
    
    @Column (name = "change_user")
    private String userChange; 
}
