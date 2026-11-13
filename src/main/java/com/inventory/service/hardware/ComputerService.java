package com.inventory.service.hardware;

import com.inventory.exceptions.RequiredObjectsNullException;
import com.inventory.exceptions.ResourceNotFoundException;
import com.inventory.model.dto.hardware.ComputerDTO;
import com.inventory.model.hardware.Computer;
import com.inventory.repository.hardware.ComputerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.logging.Logger;

import static com.inventory.mapper.ObjectMapper.parseListObjects;
import static com.inventory.mapper.ObjectMapper.parseObject;

@Service
@Transactional 
public class ComputerService {
    
    @Autowired 
    private ComputerRepository repository;
    
    private Logger logger = Logger.getLogger(ComputerService.class.getName());
        
    @Transactional(readOnly = true)
    public List<ComputerDTO> findAll(){
        logger.info("Find all computers");
        var computers = parseListObjects(repository.findAll(), ComputerDTO.class);
        return computers;
    }
    
    @Transactional(readOnly = true)
    public ComputerDTO findById(Long id){
        logger.info("Find a one computer");
        var entity = repository.findById(id).orElseThrow(()
        ->new ResourceNotFoundException("No records found for this id;"));
        var dto = parseObject(entity, ComputerDTO.class);
        return dto;
    }
    
    
    public ComputerDTO create(ComputerDTO computerDTO){
        if (computerDTO == null) throw new RequiredObjectsNullException();
        logger.info("Create a computer");
        var entity = parseObject(computerDTO, Computer.class);
        return parseObject(repository.save(entity), ComputerDTO.class);
        
    }
    
    public ComputerDTO update(ComputerDTO computerDTO){
        if(computerDTO == null) throw new RequiredObjectsNullException();
        logger.info("Updating one computer");
        Computer entity = repository.findById(computerDTO.getId()).orElseThrow(()
        -> new ResourceNotFoundException("No records found for this id"));
        setter(entity, computerDTO);
        return parseObject(repository.save(entity), ComputerDTO.class);
    }
    
    public void delete(Long id){
        logger.info("Deleting one computer");
            var entity = repository.findById(id).orElseThrow(()
        ->new ResourceNotFoundException("No records found for this id;"));
        repository.delete(entity);
    }
    
    private void setter(Computer entity, ComputerDTO dto){
        entity.setNameTag(dto.getNameTag());
        entity.setUser(dto.getUser());
        entity.setDomain(dto.getDomain());
        entity.setModelComputer(dto.getModelComputer());
        entity.setTypeComputer(dto.getTypeComputer());
        entity.setProcessor(dto.getProcessor());
        entity.setRam(dto.getRam());
        entity.setMacAddress(dto.getMacAddress());
        entity.setStorage(dto.getStorage());
        entity.setWindowsVersopm(dto.getWindowsVersopm());
        entity.setWindowsKey(dto.getWindowsKey());
        entity.setOfficeVersion(dto.getOfficeVersion());
        entity.setAntivirus(dto.getAntivirus());
    } 
}
