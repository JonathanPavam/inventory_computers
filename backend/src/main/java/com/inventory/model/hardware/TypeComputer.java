package com.inventory.model.hardware;

import jakarta.persistence.*;
import lombok.Data;

@Entity 
@Table  (name="type_computer")
@Data
public class TypeComputer {
    @Id   
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false, length = 50)
    private ComputerType type;
}

