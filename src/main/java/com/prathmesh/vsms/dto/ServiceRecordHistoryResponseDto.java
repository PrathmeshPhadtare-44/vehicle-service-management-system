package com.prathmesh.vsms.dto;

import com.prathmesh.vsms.entity.Vehicle;
import com.prathmesh.vsms.enums.ServiceStatus;
import com.prathmesh.vsms.enums.ServiceType;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Setter
@Getter
public class ServiceRecordHistoryResponseDto {
    private  Long serviceRecordId;

    private LocalDateTime createdAt;

    private ServiceType serviceType;

    private String description;

    private BigDecimal cost;

    private ServiceStatus serviceStatus;




}
