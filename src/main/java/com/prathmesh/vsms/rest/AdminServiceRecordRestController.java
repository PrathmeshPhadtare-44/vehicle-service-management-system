package com.prathmesh.vsms.rest;


import com.prathmesh.vsms.dto.AdminServiceRecordResponseByIdDto;
import com.prathmesh.vsms.dto.BookedServiceResponseDto;
import com.prathmesh.vsms.dto.UpdateServiceRecordRequestDto;
import com.prathmesh.vsms.dto.UpdateServiceStatusResponseDto;
import com.prathmesh.vsms.entity.ServiceRecord;
import com.prathmesh.vsms.service.impl.AdminServiceRecordServiceImp;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminServiceRecordRestController {
    private AdminServiceRecordServiceImp adminServiceRecordServiceImp;
    public AdminServiceRecordRestController( AdminServiceRecordServiceImp adminServiceRecordServiceImp){
        this.adminServiceRecordServiceImp = adminServiceRecordServiceImp;
    }
    @GetMapping("/service-record/{serviceRecordId}")
    public ResponseEntity<AdminServiceRecordResponseByIdDto> getBookedServiceById(@PathVariable Long serviceRecordId){
        AdminServiceRecordResponseByIdDto response = adminServiceRecordServiceImp.getBookedServiceRecordById(serviceRecordId);
        return ResponseEntity.ok(response);
    }
@GetMapping("/service-record")
public ResponseEntity<List<BookedServiceResponseDto>> getAllBookedService(){
    List<BookedServiceResponseDto> bookedServiceList = adminServiceRecordServiceImp.getBookedServiceRecord();
    return ResponseEntity.ok(bookedServiceList);
}

    @PatchMapping("/service-record/{id}/status")
    public ResponseEntity<UpdateServiceStatusResponseDto> startService(@PathVariable Long id){
        UpdateServiceStatusResponseDto response = adminServiceRecordServiceImp.startService(id);
                return  ResponseEntity.ok(response);
    }
    @PatchMapping("/admin/service-records/{id}")
    public ResponseEntity<AdminServiceRecordResponseByIdDto> updateServiceRecord(
            @PathVariable Long id,
            @Valid @RequestBody UpdateServiceRecordRequestDto request){
        AdminServiceRecordResponseByIdDto response = adminServiceRecordServiceImp.updateServiceRecord(id,request);


return ResponseEntity.ok(response);
    }

}
