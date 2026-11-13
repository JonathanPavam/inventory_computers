package com.inventory.repository.organization;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.model.organization.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long>{}
