package com.inventory.model.dto.hardware;

import com.inventory.model.hardware.ComputerType;
import lombok.Data;

@Data
public class TypeComputerDTO {
    private Long id;
    private ComputerType type;
    private String nameTag;

}

