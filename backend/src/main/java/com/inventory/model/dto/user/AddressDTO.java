package com.inventory.model.dto.user;

import lombok.Data;

@Data 
public class AddressDTO {
    private Long id;
    private String cep;
    private String country;
    private String state;
    private String city;
    private String neighborhood;
    private String street;
    private String number;
}
