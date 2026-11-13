package com.inventory.repository.hardware;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.model.hardware.Processor;

public interface ProcessorRepository extends JpaRepository<Long, Processor> {}
