package com.inventory.repository.hardware;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.model.hardware.Storage;

public interface StorageRepository extends JpaRepository<Storage, Long>{}

