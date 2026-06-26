package com.prathmesh.vsms.service;

import com.prathmesh.vsms.dto.VehicleRequestDto;
import com.prathmesh.vsms.dto.VehicleResponseDto;

import java.util.List;

public interface VehicleService {
    VehicleResponseDto saveVehicle(VehicleRequestDto dto);

    List<VehicleResponseDto> getVehiclesByCustomer(Long customerId);
    void deleteVehicle(Long vehicleId);
}
