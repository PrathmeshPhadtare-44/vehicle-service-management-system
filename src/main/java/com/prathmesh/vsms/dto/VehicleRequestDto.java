package com.prathmesh.vsms.dto;

import com.prathmesh.vsms.enums.VehicleType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class VehicleRequestDto {
    @NotBlank(message = "Vehicle number is required.")
    private String vehicleNumber;

    @NotNull(message = "Vehicle type is required.")
    private VehicleType vehicleType;

    @NotNull(message = "Vehicle model is required.")
    private String model;

    @NotNull(message = "Customer id is required.")
    private long customerId;
}
