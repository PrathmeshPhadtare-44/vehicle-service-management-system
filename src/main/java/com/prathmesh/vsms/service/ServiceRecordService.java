package com.prathmesh.vsms.service;

import com.prathmesh.vsms.dto.NewServiceRecordRequestDto;
import com.prathmesh.vsms.dto.NewServiceRecordResponseDto;
import com.prathmesh.vsms.dto.ServiceRecordHistoryResponseDto;
import com.prathmesh.vsms.entity.ServiceRecord;

import java.util.List;

public interface ServiceRecordService {
public List<ServiceRecordHistoryResponseDto> getServiceHistoryByVehicleId(Long vehicleId);

public NewServiceRecordResponseDto save(NewServiceRecordRequestDto dto);
}
