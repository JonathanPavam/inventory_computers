package com.inventory.service.hardware;

import com.inventory.exceptions.RequiredObjectsNullException;
import com.inventory.exceptions.ResourceNotFoundException;
import com.inventory.model.dto.hardware.ModelComputerDTO;
import com.inventory.model.hardware.ModelComputer;
import com.inventory.repository.hardware.ModelComputerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.logging.Logger;

import static com.inventory.mapper.ObjectMapper.parseListObjects;
import static com.inventory.mapper.ObjectMapper.parseObject;

@Service
@Transactional 
public class ModelComputerService {
    
    @Autowired 
    private ModelComputerRepository repository;
    
    private Logger logger = Logger.getLogger(ModelComputerService.class.getName());
        
    @Transactional(readOnly = true)
    public List<ModelComputerDTO> findAll(){
        logger.info("Find all model computers");
        var computers = parseListObjects(repository.findAll(), ModelComputerDTO.class);
        return computers;
    }
    
    @Transactional(readOnly = true)
    public ModelComputerDTO findById(Long id){
        logger.info("Find a one model computer");
        var entity = repository.findById(id).orElseThrow(()
        ->new ResourceNotFoundException("No records found for this id;"));
        var dto = parseObject(entity, ModelComputerDTO.class);
        return dto;
    }
    
    
    public ModelComputerDTO create(ModelComputerDTO modelComputerDTO){
        if (modelComputerDTO == null) throw new RequiredObjectsNullException();
        logger.info("Create a model computer");
        var entity = parseObject(modelComputerDTO, ModelComputer.class);
         return parseObject(repository.save(entity), ModelComputerDTO.class); 
    }
    
    public ModelComputerDTO update(ModelComputerDTO modelComputerDTO){
        if(modelComputerDTO == null) throw new RequiredObjectsNullException();
        logger.info("Updating one model computer");
        ModelComputer entity = repository.findById(modelComputerDTO.getId()).orElseThrow(()
        -> new ResourceNotFoundException("No records found for this id"));
        setter(entity, modelComputerDTO);
        return parseObject(repository.save(entity), ModelComputerDTO.class);
    }
    
    public void delete(Long id){
        logger.info("Deleting one model computer");
            var entity = repository.findById(id).orElseThrow(()
        ->new ResourceNotFoundException("No records found for this id;"));
        repository.delete(entity);
    }
    
    private void setter(ModelComputer entity, ModelComputerDTO dto){
        entity.setModel_name(dto.getModel_name());
    } 
    
        
}
