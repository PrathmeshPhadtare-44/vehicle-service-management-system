package com.prathmesh.vsms.service.impl;

import com.prathmesh.vsms.dto.ServiceRecordHistoryResponseDto;
import com.prathmesh.vsms.entity.ServiceRecord;
import com.prathmesh.vsms.exception.ResourceNotFoundException;
import com.prathmesh.vsms.repository.ServiceRecordRepository;
import com.prathmesh.vsms.repository.VehicleRepository;
import com.prathmesh.vsms.service.ServiceRecordService;
import org.springframework.stereotype.Service;

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
}
