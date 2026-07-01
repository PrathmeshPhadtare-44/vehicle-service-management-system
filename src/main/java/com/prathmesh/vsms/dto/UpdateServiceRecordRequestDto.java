package com.prathmesh.vsms.dto;

import com.prathmesh.vsms.enums.ServiceStatus;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class UpdateServiceRecordRequestDto {

    @NotBlank(message = "Mechanic notes cannot be empty.")
    private String mechanicNotes;

    @NotNull(message = "Cost is required.")
    @DecimalMin(value = "0.0", inclusive = true, message = "Cost cannot be negative.")
    private BigDecimal cost;

    @NotNull(message = "Service status is required.")
    private ServiceStatus serviceStatus;

}
