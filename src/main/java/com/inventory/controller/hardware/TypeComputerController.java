package com.inventory.controller.hardware;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.inventory.model.dto.hardware.TypeComputerDTO;
import com.inventory.service.hardware.TypeComputerService;

@RestController
@RequestMapping ("/api/typeComputer/v1")
public class TypeComputerController {
    @Autowired 
    TypeComputerService service;
    
    @GetMapping(produces ={
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE,
            MediaType.APPLICATION_YAML_VALUE})
    public ResponseEntity<List<TypeComputerDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }
    
    @GetMapping(value = "/{id}",
        produces ={
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE,
            MediaType.APPLICATION_YAML_VALUE})
    public ResponseEntity<TypeComputerDTO> findById(Long id) {
        return ResponseEntity.ok(service.findById(id));
    }
    
    @PostMapping (
        consumes ={
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE,
            MediaType.APPLICATION_YAML_VALUE},
        produces ={
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE,
            MediaType.APPLICATION_YAML_VALUE})
    public ResponseEntity<TypeComputerDTO> create(@RequestBody TypeComputerDTO computer) {
        return ResponseEntity.ok(service.create(computer)); 
    }
    
    @PutMapping (
        consumes ={
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE,
            MediaType.APPLICATION_YAML_VALUE},
        produces ={
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE,
            MediaType.APPLICATION_YAML_VALUE})
    public ResponseEntity<TypeComputerDTO> update(@RequestBody TypeComputerDTO computer) {
        return ResponseEntity.ok(service.update(computer));
    }
    
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}