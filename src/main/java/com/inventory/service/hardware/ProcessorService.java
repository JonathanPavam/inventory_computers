package com.inventory.service.hardware;

import com.inventory.exceptions.RequiredObjectsNullException;
import com.inventory.exceptions.ResourceNotFoundException;
import com.inventory.model.dto.hardware.ProcessorDTO;
import com.inventory.model.hardware.Processor;
import com.inventory.repository.hardware.ProcessorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.logging.Logger;

import static com.inventory.mapper.ObjectMapper.parseListObjects;
import static com.inventory.mapper.ObjectMapper.parseObject;

@Service
@Transactional 
public class ProcessorService {
    
    @Autowired 
    private ProcessorRepository repository;
    
    private Logger logger = Logger.getLogger(ProcessorService.class.getName());
        
    @Transactional(readOnly = true)
    public List<ProcessorDTO> findAll(){
        logger.info("Find all processors");
        var computers = parseListObjects(repository.findAll(), ProcessorDTO.class);
        return computers;
    }
    
    @Transactional(readOnly = true)
    public ProcessorDTO findById(Long id){
        logger.info("Find a one processor");
        var entity = repository.findById(id).orElseThrow(()
        ->new ResourceNotFoundException("No records found for this id;"));
        var dto = parseObject(entity, ProcessorDTO.class);
        return dto;
    }
    
    
    public ProcessorDTO create(ProcessorDTO processorDTO){
        if (processorDTO == null) throw new RequiredObjectsNullException();
        logger.info("Create a processor");
        var entity = parseObject(processorDTO, Processor.class);
         return parseObject(repository.save(entity), ProcessorDTO.class); 
    }
    
    public ProcessorDTO update(ProcessorDTO processorDTO){
        if(processorDTO == null) throw new RequiredObjectsNullException();
        logger.info("Updating one processor");
        Processor entity = repository.findById(processorDTO.getId()).orElseThrow(()
        -> new ResourceNotFoundException("No records found for this id"));
        setter(entity, processorDTO);
        return parseObject(repository.save(entity), ProcessorDTO.class);
    }
    
    public void delete(Long id){
        logger.info("Deleting one processor");
            var entity = repository.findById(id).orElseThrow(()
        ->new ResourceNotFoundException("No records found for this id;"));
        repository.delete(entity);
    }
    
    private void setter(Processor entity, ProcessorDTO dto){
        entity.setName(dto.getName());
        entity.setMark(dto.getMark());
    } 
    
        
}
