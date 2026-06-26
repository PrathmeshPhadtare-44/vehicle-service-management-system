package com.prathmesh.vsms.service.impl;

import com.prathmesh.vsms.dto.VehicleRequestDto;
import com.prathmesh.vsms.dto.VehicleResponseDto;
import com.prathmesh.vsms.entity.Customer;
import com.prathmesh.vsms.entity.Vehicle;
import com.prathmesh.vsms.exception.ResourceNotFoundException;
import com.prathmesh.vsms.repository.CustomerRepository;
import com.prathmesh.vsms.repository.VehicleRepository;
import com.prathmesh.vsms.service.VehicleService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService {
    private VehicleRepository vehicleRepository;
    private CustomerRepository customerRepository;
    public VehicleServiceImpl(VehicleRepository vehicleRepository,
                              CustomerRepository customerRepository){
        this.vehicleRepository = vehicleRepository;
        this.customerRepository = customerRepository;
    }


    @Override
    public VehicleResponseDto saveVehicle(VehicleRequestDto dto) {
        Customer customer = customerRepository
                .findById(dto.getCustomerId())
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found."));
        Vehicle vehicle = new Vehicle();
       vehicle.setVehicleNumber(dto.getVehicleNumber());
       vehicle.setVehicleType(dto.getVehicleType());
        vehicle.setCustomer(customer);
        Vehicle savedVehicle = vehicleRepository.save(vehicle);

        VehicleResponseDto vehicleResponseDto = new VehicleResponseDto();
        vehicleResponseDto.setVehicleNumber(savedVehicle.getVehicleNumber());
        vehicleResponseDto.setVehicleType(savedVehicle.getVehicleType());
        vehicleResponseDto.setModel(savedVehicle.getModel());
        vehicleResponseDto.setCustomerName(customer.getName());
        return vehicleResponseDto;
    }

    @Override
    public List<VehicleResponseDto> getVehiclesByCustomer(Long customerId) {
        List<VehicleResponseDto> responseDtoList = new ArrayList<>();
        List<Vehicle> vehicles = vehicleRepository.findByCustomerCustomerId(customerId);
        for (Vehicle vehicle : vehicles){
            VehicleResponseDto dto  = new VehicleResponseDto();
            dto.setVehicleID(vehicle.getVehicleId());
            dto.setVehicleNumber(vehicle.getVehicleNumber());
            dto.setVehicleType(vehicle.getVehicleType());
            dto.setCustomerName(vehicle.getCustomer().getName());

            responseDtoList.add(dto);
        }
        return responseDtoList;
    }


    @Override
    public void deleteVehicle(Long vehicleId) {
        vehicleRepository.deleteById(vehicleId);
    }
}
