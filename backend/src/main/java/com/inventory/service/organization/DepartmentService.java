package com.inventory.service.organization;

import com.inventory.exceptions.RequiredObjectsNullException;
import com.inventory.exceptions.ResourceNotFoundException;
import com.inventory.model.dto.organization.DepartmentDTO;
import com.inventory.model.organization.Department;
import com.inventory.repository.organization.DepartmentRepository;
import static com.inventory.mapper.ObjectMapper.parseListObjects;
import static com.inventory.mapper.ObjectMapper.parseObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import java.util.logging.Logger;

@Service
@Transactional 
public class DepartmentService {
    
    @Autowired 
    private DepartmentRepository repository;
    
    private Logger logger = Logger.getLogger(DepartmentService.class.getName());

    @Transactional (readOnly = true)
    public List<DepartmentDTO> findAll(){
        logger.info("Find all departments");
        var positions = parseListObjects(repository.findAll(), DepartmentDTO.class);
        return positions;
    }
    
    @Transactional (readOnly = true)
    public DepartmentDTO findById(Long id){
        logger.info("Find a one department");
        var entity = repository.findById(id).orElseThrow(()
        ->new ResourceNotFoundException("No records found for this id;"));
        var dto = parseObject(entity, DepartmentDTO.class);
        return dto;
    }
    
    public DepartmentDTO create(DepartmentDTO position){
        if(position == null) throw new RequiredObjectsNullException();
        logger.info("Create a department");
        var entity = parseObject(position, Department.class);
        var dto = parseObject(repository.save(entity), DepartmentDTO.class);
        return dto;
    }
    
    public DepartmentDTO update(DepartmentDTO departmentDTO){
        if(departmentDTO == null) throw new RequiredObjectsNullException();
        logger.info("Updating one department");
        Department entity = repository.findById(departmentDTO.getId()).orElseThrow(()
        -> new ResourceNotFoundException("No records found for this id"));
        setter(entity, departmentDTO);
        return parseObject(repository.save(entity), DepartmentDTO.class);
    }
    
    public void delete(Long id){
        logger.info("Deleting one department");
            var entity = repository.findById(id).orElseThrow(()
        ->new ResourceNotFoundException("No records found for this id;"));
        repository.delete(entity);
    }
    
    private void setter(Department entity, DepartmentDTO dto){
        entity.setName(dto.getName());
    }
}
