package com.inventory.service.hardware;

import com.inventory.exceptions.RequiredObjectsNullException;
import com.inventory.exceptions.ResourceNotFoundException;
import com.inventory.model.dto.hardware.RamDTO;
import com.inventory.model.hardware.Ram;
import com.inventory.repository.hardware.RamRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.logging.Logger;

import static com.inventory.mapper.ObjectMapper.parseListObjects;
import static com.inventory.mapper.ObjectMapper.parseObject;

@Service
@Transactional 
public class RamService {
    
    @Autowired 
    private RamRepository repository;
    
    private Logger logger = Logger.getLogger(RamService.class.getName());
        
    @Transactional(readOnly = true)
    public List<RamDTO> findAll(){
        logger.info("Find all Rams");
        var computers = parseListObjects(repository.findAll(), RamDTO.class);
        return computers;
    }
    
    @Transactional(readOnly = true)
    public RamDTO findById(Long id){
        logger.info("Find a one ram");
        var entity = repository.findById(id).orElseThrow(()
        ->new ResourceNotFoundException("No records found for this id;"));
        var dto = parseObject(entity, RamDTO.class);
        return dto;
    }
    
    
    public RamDTO create(RamDTO ramDTO){
        if (ramDTO == null) throw new RequiredObjectsNullException();
        logger.info("Create a ram");
        var entity = parseObject(ramDTO, Ram.class);
         return parseObject(repository.save(entity), RamDTO.class); 
    }
    
    public RamDTO update(RamDTO ramDTO){
        if(ramDTO == null) throw new RequiredObjectsNullException();
        logger.info("Updating one ram");
        Ram entity = repository.findById(ramDTO.getId()).orElseThrow(()
        -> new ResourceNotFoundException("No records found for this id"));
        setter(entity, ramDTO);
        return parseObject(repository.save(entity), RamDTO.class);
    }
    
    public void delete(Long id){
        logger.info("Deleting one ram");
            var entity = repository.findById(id).orElseThrow(()
        ->new ResourceNotFoundException("No records found for this id;"));
        repository.delete(entity);
    }
    
    private void setter(Ram entity, RamDTO dto){
        entity.setName(dto.getName());
        entity.setMark(dto.getMark());
    } 
    
        
}
