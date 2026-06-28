package com.prathmesh.vsms.dto;

import com.prathmesh.vsms.enums.ServiceStatus;
import com.prathmesh.vsms.enums.ServiceType;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Setter
@Getter
public class NewServiceRecordResponseDto {
    private Long serviceRecordId;

    private String vehicleNumber;

    private String model;

    private ServiceType serviceType;

    private String description;

    private ServiceStatus serviceStatus;

    private BigDecimal cost;

    private LocalDateTime createdAt;

}
