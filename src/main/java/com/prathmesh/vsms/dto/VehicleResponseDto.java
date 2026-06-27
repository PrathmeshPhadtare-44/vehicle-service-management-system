package com.prathmesh.vsms.dto;

import com.prathmesh.vsms.enums.VehicleType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class VehicleResponseDto {

    private long   VehicleID;

    private String vehicleNumber;

    private VehicleType vehicleType;

    private String model;


    private String CustomerName;

}
