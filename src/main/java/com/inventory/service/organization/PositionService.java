package com.inventory.service.organization;

import com.inventory.exceptions.RequiredObjectsNullException;
import com.inventory.exceptions.ResourceNotFoundException;
import com.inventory.model.dto.organization.PositionDTO;
import com.inventory.model.organization.Position;
import com.inventory.repository.organization.PositionRepository;
import static com.inventory.mapper.ObjectMapper.parseListObjects;
import static com.inventory.mapper.ObjectMapper.parseObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import java.util.logging.Logger;

@Service
@Transactional 
public class PositionService {
    
    @Autowired 
    private PositionRepository repository;
    
    private Logger logger = Logger.getLogger(PositionService.class.getName());

    @Transactional (readOnly = true)
    public List<PositionDTO> findAll(){
        logger.info("Find all positions");
        var positions = parseListObjects(repository.findAll(), PositionDTO.class);
        return positions;
    }
    
    @Transactional (readOnly = true)
    public PositionDTO findById(Long id){
        logger.info("Find a one position");
        var entity = repository.findById(id).orElseThrow(()
        ->new ResourceNotFoundException("No records found for this id;"));
        var dto = parseObject(entity, PositionDTO.class);
        return dto;
    }
    
    public PositionDTO create(PositionDTO position){
        if(position == null) throw new RequiredObjectsNullException();
        logger.info("Create a position");
        var entity = parseObject(position, Position.class);
        var dto = parseObject(repository.save(entity), PositionDTO.class);
        return dto;
    }
    
    public PositionDTO update(PositionDTO positionDTO){
        if(positionDTO == null) throw new RequiredObjectsNullException();
        logger.info("Updating one position");
        Position entity = repository.findById(positionDTO.getId()).orElseThrow(()
        -> new ResourceNotFoundException("No records found for this id"));
        setter(entity, positionDTO);
        return parseObject(repository.save(entity), PositionDTO.class);
    }
    
    public void delelte(Long id){
        logger.info("Deleting one position");
            var entity = repository.findById(id).orElseThrow(()
        ->new ResourceNotFoundException("No records found for this id;"));
        repository.delete(entity);
    }
    
    private void setter(Position entity, PositionDTO dto){
        entity.setName(dto.getName());
    }
}
