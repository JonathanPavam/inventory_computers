package com.inventory.service.hardware;

import com.inventory.exceptions.RequiredObjectsNullException;
import com.inventory.exceptions.ResourceNotFoundException;
import com.inventory.model.dto.hardware.StorageDTO;
import com.inventory.model.hardware.Storage;
import com.inventory.repository.hardware.StorageRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.logging.Logger;

import static com.inventory.mapper.ObjectMapper.parseListObjects;
import static com.inventory.mapper.ObjectMapper.parseObject;

@Service
@Transactional 
public class StorageService {
    
    @Autowired 
    private StorageRepository repository;
    
    private Logger logger = Logger.getLogger(StorageService.class.getName());
        
    @Transactional(readOnly = true)
    public List<StorageDTO> findAll(){
        logger.info("Find all Storages");
        var computers = parseListObjects(repository.findAll(), StorageDTO.class);
        return computers;
    }
    
    @Transactional(readOnly = true)
    public StorageDTO findById(Long id){
        logger.info("Find a one storage");
        var entity = repository.findById(id).orElseThrow(()
        ->new ResourceNotFoundException("No records found for this id;"));
        var dto = parseObject(entity, StorageDTO.class);
        return dto;
    }
    
    
    public StorageDTO create(StorageDTO storageDTO){
        if (storageDTO == null) throw new RequiredObjectsNullException();
        logger.info("Create a storage");
        var entity = parseObject(storageDTO, Storage.class);
         return parseObject(repository.save(entity), StorageDTO.class); 
    }
    
    public StorageDTO update(StorageDTO storageDTO){
        if(storageDTO == null) throw new RequiredObjectsNullException();
        logger.info("Updating one storage");
        Storage entity = repository.findById(storageDTO.getId()).orElseThrow(()
        -> new ResourceNotFoundException("No records found for this id"));
        setter(entity, storageDTO);
        return parseObject(repository.save(entity), StorageDTO.class);
    }
    
    public void delete(Long id){
        logger.info("Deleting one storage");
            var entity = repository.findById(id).orElseThrow(()
        ->new ResourceNotFoundException("No records found for this id;"));
        repository.delete(entity);
    }
    
    private void setter(Storage entity, StorageDTO dto){
        entity.setType(dto.getType());
        entity.setMark(dto.getMark());
        entity.setSize(dto.getSize());
    } 
    
        
}
