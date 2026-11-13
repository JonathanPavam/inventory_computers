package com.inventory.service.user;

import com.inventory.exceptions.RequiredObjectsNullException;
import com.inventory.exceptions.ResourceNotFoundException;
import com.inventory.model.dto.user.*;
import com.inventory.model.user.User;
import com.inventory.repository.user.UserRepository;
import static com.inventory.mapper.ObjectMapper.parseListObjects;
import static com.inventory.mapper.ObjectMapper.parseObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import java.util.logging.Logger;

@Service
@Transactional 
public class UserService {
    
    @Autowired 
    private UserRepository repository;
    
    private Logger logger = Logger.getLogger(UserService.class.getName());

    @Transactional (readOnly = true)
    public List<UserDTO> findAll(){
        logger.info("Find all Users");
        var users = parseListObjects(repository.findAll(), UserDTO.class);
        return users;
    }
    
    @Transactional (readOnly = true)
    public UserDTO findById(Long id){
        logger.info("Find a one user");
        var entity = repository.findById(id).orElseThrow(()
        ->new ResourceNotFoundException("No records found for this id;"));
        var dto = parseObject(entity, UserDTO.class);
        return dto;
    }
    
    public UserDTO create(UserDTO user){
        if(user == null) throw new RequiredObjectsNullException();
        logger.info("Create a user");
        var entity = parseObject(user, User.class);
        var dto = parseObject(repository.save(entity), UserDTO.class);
        return dto;
    }
    
    public UserDTO update(UserDTO userDTO){
        if(userDTO == null) throw new RequiredObjectsNullException();
        logger.info("Updating one user");
        User entity = repository.findById(userDTO.getId()).orElseThrow(()
        -> new ResourceNotFoundException("No records found for this id"));
        setter(entity, userDTO);
        return parseObject(repository.save(entity), UserDTO.class);
    }
    
    public void delelte(Long id){
        logger.info("Deleting one user");
            var entity = repository.findById(id).orElseThrow(()
        ->new ResourceNotFoundException("No records found for this id;"));
        repository.delete(entity);
    }
    
    private void setter(User entity, UserDTO dto){
        entity.setFirst_name(dto.getFirst_name());
        entity.setLast_name(dto.getLast_name());
        entity.setUser(dto.getUser());
        entity.setEmail(dto.getEmail());
        entity.setRegister(dto.getRegister());
        entity.setAddress(dto.getAddress());
        entity.setGender(dto.getGender());
        entity.setDepartment(dto.getDepartment());
        entity.setPosition(dto.getPosition());
        entity.setChangeDate(dto.getChangeDate());
        entity.setUserChange(dto.getUserChange());
    }
}
