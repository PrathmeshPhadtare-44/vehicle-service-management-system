package com.prathmesh.vsms.repository;

import com.prathmesh.vsms.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicle , Long> {
    List<Vehicle> findByCustomerCustomerId(Long customerId);

}
