package com.prathmesh.vsms.rest;

import com.prathmesh.vsms.dto.NewServiceRecordRequestDto;
import com.prathmesh.vsms.dto.NewServiceRecordResponseDto;
import com.prathmesh.vsms.dto.ServiceRecordHistoryResponseDto;
import com.prathmesh.vsms.service.impl.ServiceRecordServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/service-records")
public class ServiceRecordRestController {
    private ServiceRecordServiceImpl serviceRecordServiceImpl;
    public ServiceRecordRestController(ServiceRecordServiceImpl serviceRecordServiceImpl)
    {
        this.serviceRecordServiceImpl = serviceRecordServiceImpl;
    }
    @GetMapping("{vehicleId}/services")
    public ResponseEntity<List<ServiceRecordHistoryResponseDto>> getServiceRecordHistory(@PathVariable Long vehicleId)
    {
        List<ServiceRecordHistoryResponseDto> dto = serviceRecordServiceImpl.getServiceHistoryByVehicleId(vehicleId);
        return ResponseEntity.ok(dto);
    }

    @PostMapping("/services/new")
    public ResponseEntity<NewServiceRecordResponseDto> addNewServiceRecord(@Valid @RequestBody NewServiceRecordRequestDto dto){
NewServiceRecordResponseDto dto1 = serviceRecordServiceImpl.save(dto);
return ResponseEntity.status(HttpStatus.CREATED)
        .body(dto1);
    }
}

