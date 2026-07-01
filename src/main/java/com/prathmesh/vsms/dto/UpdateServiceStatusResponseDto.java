package com.prathmesh.vsms.dto;
import com.prathmesh.vsms.enums.ServiceStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateServiceStatusResponseDto {

    private Long serviceId;
    private ServiceStatus serviceStatus;

}