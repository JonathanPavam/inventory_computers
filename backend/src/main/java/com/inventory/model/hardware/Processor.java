package com.inventory.model.hardware;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity 
@Table (name="processor")
@Data 
public class Processor {
    @Id  
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column (name="name", nullable = false, length = 50)
    private String name;
    
    @Column (name="mark", nullable = false, length = 50)
    private String mark;
}
