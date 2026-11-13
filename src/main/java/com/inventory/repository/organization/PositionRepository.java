package com.inventory.repository.organization;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.model.organization.Position;

public interface PositionRepository extends JpaRepository <Position, Long> {}
