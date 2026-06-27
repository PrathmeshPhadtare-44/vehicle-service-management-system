package com.prathmesh.vsms.repository;

import com.prathmesh.vsms.entity.ServiceRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServiceRecordRepository extends JpaRepository<ServiceRecord , Long> {
    List<ServiceRecord> findByVehicleVehicleId(Long vehicleId);
}
