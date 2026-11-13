package com.inventory.model.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity 
@Table (name="adress")
@Data 
public class Address {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column (name="cep", nullable = false, length = 80)
    private String cep;
    
    @Column (name="country", nullable = false, length = 80)
    private String country;
    
    @Column (name="state", nullable = false, length = 80)
    private String state;
    
    @Column (name="city", nullable = false, length = 80)
    private String city;
    
    @Column (name="neighborhood", nullable = false, length = 80)
    private String neighborhood;
    
    @Column (name="street", nullable = false, length = 80)
    private String street;
    
    @Column (name="number", nullable = false, length = 80)
    private String number;
}
