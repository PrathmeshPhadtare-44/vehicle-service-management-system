package com.prathmesh.vsms.dto;

import com.prathmesh.vsms.enums.ServiceStatus;
import com.prathmesh.vsms.enums.ServiceType;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class NewServiceRecordResponseDto {
    private Long serviceRecordId;

    private String vehicleNumber;

    private String vehicleModel;

    private ServiceType serviceType;

    private String description;

    private ServiceStatus serviceStatus;

    private BigDecimal cost;

    private LocalDateTime createdAt;

}
