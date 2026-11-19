package com.inventory.repository.hardware;

import com.inventory.model.hardware.Computer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComputerRepository extends JpaRepository<Computer, Long> {
}
