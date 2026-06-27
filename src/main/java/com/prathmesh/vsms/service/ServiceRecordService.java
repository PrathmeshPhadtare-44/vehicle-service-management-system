package com.prathmesh.vsms.service;

import com.prathmesh.vsms.dto.ServiceRecordHistoryResponseDto;

import java.util.List;

public interface ServiceRecordService {
public List<ServiceRecordHistoryResponseDto> getServiceHistoryByVehicleId(Long vehicleId);


}
