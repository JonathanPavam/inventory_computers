package com.inventory.model.dto.hardware;

import com.inventory.model.hardware.*;
import com.inventory.model.user.User;
import lombok.Data;

@Data
public class ComputerDTO {
    private Long id;
    private String nameTag;
    private User user;
    private Boolean domain;
    private ModelComputer modelComputer;
    private TypeComputer TypeComputer;
    private Processor processor;
    private Ram ram;
    private String macAddress;
    private Storage storage;
    private String windowsVersion;
    private String windowsKey;
    private String officeVersion;
    private String officeKey;
    private Boolean antivirus;
}
