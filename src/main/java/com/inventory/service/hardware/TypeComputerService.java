package com.inventory.service.hardware;

import com.inventory.exceptions.RequiredObjectsNullException;
import com.inventory.exceptions.ResourceNotFoundException;
import com.inventory.model.dto.hardware.TypeComputerDTO;
import com.inventory.model.hardware.TypeComputer;
import com.inventory.repository.hardware.TypeComputerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.logging.Logger;

import static com.inventory.mapper.ObjectMapper.parseListObjects;
import static com.inventory.mapper.ObjectMapper.parseObject;

@Service
@Transactional 
public class TypeComputerService {
    
    @Autowired 
    private TypeComputerRepository repository;
    
    private Logger logger = Logger.getLogger(TypeComputerService.class.getName());
        
    @Transactional(readOnly = true)
    public List<TypeComputerDTO> findAll(){
        logger.info("Find all TypeComputers");
        var computers = parseListObjects(repository.findAll(), TypeComputerDTO.class);
        return computers;
    }
    
    @Transactional(readOnly = true)
    public TypeComputerDTO findById(Long id){
        logger.info("Find a one typeComputer");
        var entity = repository.findById(id).orElseThrow(()
        ->new ResourceNotFoundException("No records found for this id;"));
        var dto = parseObject(entity, TypeComputerDTO.class);
        return dto;
    }
    
    
    public TypeComputerDTO create(TypeComputerDTO typeComputerDTO){
        if (typeComputerDTO == null) throw new RequiredObjectsNullException();
        logger.info("Create a typeComputer");
        var entity = parseObject(typeComputerDTO, TypeComputer.class);
         return parseObject(repository.save(entity), TypeComputerDTO.class); 
    }
    
    public TypeComputerDTO update(TypeComputerDTO typeComputerDTO){
        if(typeComputerDTO == null) throw new RequiredObjectsNullException();
        logger.info("Updating one typeComputer");
        TypeComputer entity = repository.findById(typeComputerDTO.getId()).orElseThrow(()
        -> new ResourceNotFoundException("No records found for this id"));
        setter(entity, typeComputerDTO);
        return parseObject(repository.save(entity), TypeComputerDTO.class);
    }
    
    public void delete(Long id){
        logger.info("Deleting one typeComputer");
            var entity = repository.findById(id).orElseThrow(()
        ->new ResourceNotFoundException("No records found for this id;"));
        repository.delete(entity);
    }
    
    private void setter(TypeComputer entity, TypeComputerDTO dto){
        entity.setType(dto.getType());
    } 
    
        
}
