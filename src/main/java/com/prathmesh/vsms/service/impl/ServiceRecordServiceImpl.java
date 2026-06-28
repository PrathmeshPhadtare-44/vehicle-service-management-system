package com.prathmesh.vsms.service.impl;

import com.prathmesh.vsms.dto.NewServiceRecordRequestDto;
import com.prathmesh.vsms.dto.NewServiceRecordResponseDto;
import com.prathmesh.vsms.dto.ServiceRecordHistoryResponseDto;
import com.prathmesh.vsms.entity.ServiceRecord;
import com.prathmesh.vsms.entity.Vehicle;
import com.prathmesh.vsms.enums.ServiceStatus;
import com.prathmesh.vsms.exception.ResourceNotFoundException;
import com.prathmesh.vsms.repository.ServiceRecordRepository;
import com.prathmesh.vsms.repository.VehicleRepository;
import com.prathmesh.vsms.service.ServiceRecordService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Service
public class ServiceRecordServiceImpl implements ServiceRecordService {
    private ServiceRecordRepository serviceRecordRepository;
    private VehicleRepository vehicleRepository;
    public ServiceRecordServiceImpl(ServiceRecordRepository serviceRecordRepository , VehicleRepository vehicleRepository)
    {
        this.vehicleRepository = vehicleRepository;
        this.serviceRecordRepository = serviceRecordRepository;
    }

    @Override
    public List<ServiceRecordHistoryResponseDto> getServiceHistoryByVehicleId(Long vehicleId) {
        vehicleRepository.findById(vehicleId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Vehicle not found."));

        List<ServiceRecord> serviceRecords = serviceRecordRepository.findByVehicleVehicleId(vehicleId);
        List<ServiceRecordHistoryResponseDto> dtos = new ArrayList<>();
        for (ServiceRecord serviceRecord : serviceRecords){
            ServiceRecordHistoryResponseDto dto = new ServiceRecordHistoryResponseDto();
            dto.setServiceRecordId(serviceRecord.getServiceRecordId());
            dto.setServiceType(serviceRecord.getServiceType());
            dto.setDescription(serviceRecord.getDescription());
            dto.setServiceStatus(serviceRecord.getServiceStatus());
            dto.setCreatedAt(serviceRecord.getCreatedAt());
            dto.setCost(serviceRecord.getCost());

            dtos.add(dto);
        }

        return dtos;
    }

    @Override
    public NewServiceRecordResponseDto save(NewServiceRecordRequestDto dto) {
        Vehicle vehicle = vehicleRepository.findById(dto.getVehicleId()).orElseThrow(()->new ResourceNotFoundException("Vehicle not found."));
        ServiceRecord serviceRecord = new ServiceRecord();
        serviceRecord.setDescription(dto.getDescription());
        serviceRecord.setCost(BigDecimal.ZERO);
        serviceRecord.setServiceStatus(ServiceStatus.PENDING);
        serviceRecord.setServiceType(dto.getServiceType());
        serviceRecord.setCreatedAt(LocalDateTime.now());
        serviceRecord.setVehicle(vehicle);
                          ServiceRecord savedServiceRecord = serviceRecordRepository.save(serviceRecord);
        NewServiceRecordResponseDto response = new NewServiceRecordResponseDto();

        response.setServiceRecordId(savedServiceRecord.getServiceRecordId());
        response.setCreatedAt(savedServiceRecord.getCreatedAt());
        response.setServiceType(savedServiceRecord.getServiceType());
        response.setDescription(savedServiceRecord.getDescription());
        response.setCost(savedServiceRecord.getCost());
        response.setServiceStatus(savedServiceRecord.getServiceStatus());

        response.setVehicleNumber(
                savedServiceRecord.getVehicle().getVehicleNumber()
        );

        response.setModel(
                savedServiceRecord.getVehicle().getModel()
        );
        response.setCreatedAt(savedServiceRecord.getCreatedAt());

        return response;
    }
}
