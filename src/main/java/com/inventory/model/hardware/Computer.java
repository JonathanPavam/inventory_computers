package com.inventory.model.hardware;

import com.inventory.model.user.User;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table (name="computer")
@Data
public class Computer {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name="name_tag", nullable = false, length = 10)
    private String nameTag;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    
    @Column(name="domain", nullable = false, length = 3)
    private Boolean domain;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "model_computer_id")
    private ModelComputer modelComputer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "type_computer_id", nullable = false)
    private TypeComputer TypeComputer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "processor_id", nullable = false)
    private Processor processor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ram_id", nullable = false)
    private Ram ram;
    
    @Column(name="mac_adress", length = 17)
    private String macAddress;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "storage_id", nullable = false)
    private Storage storage;
    
    @Column(name="windows_version", nullable = false, length = 20)
    private String windowsVersion;
    
    @Column(name="windows_key", length = 35)
    private String windowsKey;
    
    @Column(name="officeVersion", length = 20)
    private String officeVersion;
    
    @Column(name="office_key", length = 20)
    private String officeKey;
    
    @Column(name="antivirus", nullable = false, length = 20)
    private Boolean antivirus;
}
