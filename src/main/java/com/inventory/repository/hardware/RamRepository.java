package com.inventory.repository.hardware;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.model.hardware.Ram;

public interface RamRepository extends JpaRepository<Long, Ram> {}
