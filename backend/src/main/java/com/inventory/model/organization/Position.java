package com.inventory.model.organization;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table  (name="position")
@Data 
public class Position {
    @Id    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column (name="name", nullable = false, length = 50)
    private String name;
}
