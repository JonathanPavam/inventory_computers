package com.inventory.service.management;

import com.inventory.exceptions.RequiredObjectsNullException;
import com.inventory.exceptions.ResourceNotFoundException;
import com.inventory.model.dto.management.FinancialManagementDTO;
import com.inventory.model.management.FinancialManagement;
import com.inventory.repository.management.FinancialManagementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.logging.Logger;
import static com.inventory.mapper.ObjectMapper.parseListObjects;
import static com.inventory.mapper.ObjectMapper.parseObject;

@Service
@Transactional 
public class FinancialManagementService {
    
    @Autowired 
    private FinancialManagementRepository repository;
    
    private Logger logger = Logger.getLogger(FinancialManagementService.class.getName());
        
    @Transactional(readOnly = true)
    public List<FinancialManagementDTO> findAll(){
        logger.info("Find all financialManagement");
        var financialManagement = parseListObjects(repository.findAll(), FinancialManagementDTO.class);
        return financialManagement;
    }
    
    @Transactional(readOnly = true)
    public FinancialManagementDTO findById(Long id){
        logger.info("Find a one computer");
        var entity = repository.findById(id).orElseThrow(()
        ->new ResourceNotFoundException("No records found for this id;"));
        var dto = parseObject(entity, FinancialManagementDTO.class);
        return dto;
    }
    
    
    public FinancialManagementDTO create(FinancialManagementDTO computerDTO){
        if (computerDTO == null) throw new RequiredObjectsNullException();
        logger.info("Create a computer");
        var entity = parseObject(computerDTO, FinancialManagement.class);
        return parseObject(repository.save(entity), FinancialManagementDTO.class);
        
    }
    
    public FinancialManagementDTO update(FinancialManagementDTO computerDTO){
        if(computerDTO == null) throw new RequiredObjectsNullException();
        logger.info("Updating one computer");
        FinancialManagement entity = repository.findById(computerDTO.getId()).orElseThrow(()
        -> new ResourceNotFoundException("No records found for this id"));
        setter(entity, computerDTO);
        return parseObject(repository.save(entity), FinancialManagementDTO.class);
    }
    
    public void delete(Long id){
        logger.info("Deleting one computer");
            var entity = repository.findById(id).orElseThrow(()
        ->new ResourceNotFoundException("No records found for this id;"));
        repository.delete(entity);
    }
    
    private void setter(FinancialManagement entity, FinancialManagementDTO dto){
        entity.setExpense(dto.getExpense());
        entity.setDescription(dto.getDescription());
        entity.setProductCode(dto.getProductCode());
        entity.setEnterprise(dto.getEnterprise());
        entity.setCpnj(dto.getCpnj());
        entity.setSupplierCode(dto.getSupplierCode());
        entity.setRequestNumber(dto.getRequestNumber());
        entity.setValue(dto.getValue());
        entity.setChangeDate(dto.getChangeDate());
        entity.setUserChange(dto.getUserChange());
    } 
}
