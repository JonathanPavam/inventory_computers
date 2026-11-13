package com.inventory.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.model.user.Address;

public interface AddressRepository extends JpaRepository<Long, Address> {}