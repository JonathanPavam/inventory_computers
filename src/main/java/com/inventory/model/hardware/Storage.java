package com.inventory.model.hardware;

import jakarta.persistence.*;
import lombok.Data;
@Entity  
@Table (name="storage")
@Data
public class Storage{
    @Id  
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false, length = 50)
    private StorageType type;
    
    @Column (name="size", nullable = false, length = 50)
    private String size;
    
    @Column (name="mark", nullable = false, length = 50)
    private String mark;

}
