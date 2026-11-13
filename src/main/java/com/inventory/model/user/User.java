package com.inventory.model.user;

import java.io.Serializable;
import java.sql.Date;

import com.inventory.model.organization.*;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table  (name="user")
@Data 
public class User implements Serializable{
    
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column (name="first_name", nullable = false, length = 85)
    private String first_name;
    
    @Column (name="last_name", nullable = false, length = 85)
    private String last_name;
    
    @Column (name="user", nullable = false, length = 85)
    private String user;
    
    @Column (name="email", nullable = false, length = 85)
    private String email;
    
    @Column (name = "register",length = 6)
    private String register;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id", nullable = false)
    private Address address;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gender_id", nullable = false)
    private Gender gender;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "position_id", nullable = false)
    private Position position;
    
    @Column (name = "change_date")
    private Date changeDate;
    
    @Column (name = "change_user")
    private String userChange;     
}
