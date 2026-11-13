package com.inventory.model.dto.user;

import com.inventory.model.organization.Department;
import com.inventory.model.organization.Position;
import com.inventory.model.user.Address;
import com.inventory.model.user.Gender;
import lombok.Data;

import java.io.Serializable;
import java.sql.Date;

@Data 
public class UserDTO implements Serializable{
    private Long id;
    private String first_name;
    private String last_name;
    private String user;
    private String email;
    private String register;
    private Address address;
    private Gender gender;
    private Department department;
    private Position position;
    private Date changeDate;
    private String userChange;
}
