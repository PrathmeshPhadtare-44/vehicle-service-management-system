package com.prathmesh.vsms.controller;

import com.prathmesh.vsms.dto.VehicleRequestDto;
import com.prathmesh.vsms.dto.VehicleResponseDto;
import com.prathmesh.vsms.service.impl.VehicleServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {
    private VehicleServiceImpl vehicleService;
public VehicleController(VehicleServiceImpl vehicleService){
    this.vehicleService = vehicleService;
}
    @PostMapping("/add")
    public ResponseEntity<VehicleResponseDto> addVehicle(
            @Valid @RequestBody  VehicleRequestDto dto){

    return  ResponseEntity.ok(vehicleService.saveVehicle(dto));
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<VehicleResponseDto>> findByCustomerId(@PathVariable long customerId){
    return ResponseEntity.ok(vehicleService.getVehiclesByCustomer(customerId));

    }
    @DeleteMapping("/{vehicleId}")
    public ResponseEntity<Void> deleteVehicle(@PathVariable long vehicleId){
    vehicleService.deleteVehicle(vehicleId);
    return ResponseEntity.noContent().build();
    }
//Tested
}
