package com.inventory.repository.management;

import org.springframework.data.jpa.repository.JpaRepository;
import com.inventory.model.management.FinancialManagement;

public interface FinancialManagementRepository extends JpaRepository<FinancialManagement, Long> {

}
