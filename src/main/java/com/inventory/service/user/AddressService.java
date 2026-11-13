package com.inventory.service.user;

import com.inventory.exceptions.RequiredObjectsNullException;
import com.inventory.exceptions.ResourceNotFoundException;
import com.inventory.model.dto.user.*;
import com.inventory.model.user.Address;
import com.inventory.repository.user.AddressRepository;
import static com.inventory.mapper.ObjectMapper.parseListObjects;
import static com.inventory.mapper.ObjectMapper.parseObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import java.util.logging.Logger;

@Service
@Transactional 
public class AddressService {
    
    @Autowired 
    private AddressRepository repository;
    
    private Logger logger = Logger.getLogger(UserService.class.getName());

    @Transactional (readOnly = true)
    public List<AddressDTO> findAll(){
        logger.info("Find all Addresses");
        var address = parseListObjects(repository.findAll(), AddressDTO.class);
        return address;
    }
    
    @Transactional (readOnly = true)
    public AddressDTO findById(Long id){
        logger.info("Find a one address");
        var entity = repository.findById(id).orElseThrow(()
        ->new ResourceNotFoundException("No records found for this id;"));
        var dto = parseObject(entity, AddressDTO.class);
        return dto;
    }
    
    public AddressDTO create(AddressDTO address){
        if(address == null) throw new RequiredObjectsNullException();
        logger.info("Create a address");
        var entity = parseObject(address, Address.class);
        var dto = parseObject(repository.save(entity), AddressDTO.class);
        return dto;
    }
    
    public AddressDTO update(AddressDTO addressDTO){
        if(addressDTO == null) throw new RequiredObjectsNullException();
        logger.info("Updating one address");
        Address entity = repository.findById(addressDTO.getId()).orElseThrow(()
        -> new ResourceNotFoundException("No records found for this id"));
        setter(entity, addressDTO);
        return parseObject(repository.save(entity), AddressDTO.class);
    }
    
    public void delete(Long id){
        logger.info("Deleting one address");
            var entity = repository.findById(id).orElseThrow(()
        ->new ResourceNotFoundException("No records found for this id;"));
        repository.delete(entity);
    }
    
    private void setter(Address entity, AddressDTO dto){
        entity.setStreet(dto.getStreet());
        entity.setNumber(dto.getNumber());
        entity.setNeighborhood(dto.getNeighborhood());
        entity.setCity(dto.getCity());
        entity.setState(dto.getState());
        entity.setCountry(dto.getCountry());
        entity.setCep(dto.getCep());
    }
}
