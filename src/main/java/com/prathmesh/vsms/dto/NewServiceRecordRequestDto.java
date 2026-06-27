package com.prathmesh.vsms.dto;

import com.prathmesh.vsms.enums.ServiceType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class NewServiceRecordRequestDto {


    @NotNull(message = "Vehicle ID is required")
    private Long vehicleId;

    @NotNull(message = "Service type is required")
    private ServiceType serviceType;

    @NotBlank(message = "Description is required")
    private String description;

}
