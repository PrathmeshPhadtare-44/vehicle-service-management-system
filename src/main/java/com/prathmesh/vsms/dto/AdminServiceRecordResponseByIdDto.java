package com.prathmesh.vsms.dto;

import com.prathmesh.vsms.enums.ServiceStatus;
import com.prathmesh.vsms.enums.ServiceType;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class AdminServiceRecordResponseByIdDto {

    private Long serviceId;
    private String vehicleNumber;
    private String customerName;
    private ServiceType serviceType;
    private String customerRequest;
    private BigDecimal cost;
    private ServiceStatus serviceStatus;

}

