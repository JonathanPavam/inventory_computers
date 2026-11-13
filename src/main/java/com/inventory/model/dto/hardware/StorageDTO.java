package com.inventory.model.dto.hardware;
import com.inventory.model.hardware.StorageType;
import lombok.Data;

@Data
public class StorageDTO {
    private Long id;
    private StorageType type;
    private String size;
    private String mark;
}
