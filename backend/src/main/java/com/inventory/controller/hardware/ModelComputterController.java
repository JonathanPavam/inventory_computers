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

import com.inventory.model.dto.hardware.ModelComputerDTO;
import com.inventory.service.hardware.ModelComputerService;

@RestController
@RequestMapping ("/api/modelComputer/v1")
public class ModelComputterController {
    @Autowired 
    ModelComputerService service;
    
    @GetMapping(produces ={
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE,
            MediaType.APPLICATION_YAML_VALUE})
    public ResponseEntity<List<ModelComputerDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }
    
    @GetMapping(value = "/{id}",
        produces ={
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE,
            MediaType.APPLICATION_YAML_VALUE})
    public ResponseEntity<ModelComputerDTO> findById(Long id) {
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
    public ResponseEntity<ModelComputerDTO> create(@RequestBody ModelComputerDTO computer) {
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
    public ResponseEntity<ModelComputerDTO> update(@RequestBody ModelComputerDTO computer) {
        return ResponseEntity.ok(service.update(computer));
    }
    
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}

    
