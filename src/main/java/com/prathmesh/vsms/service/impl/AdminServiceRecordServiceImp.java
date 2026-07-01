package com.prathmesh.vsms.service.impl;

import com.prathmesh.vsms.dto.AdminServiceRecordResponseByIdDto;
import com.prathmesh.vsms.dto.BookedServiceResponseDto;
import com.prathmesh.vsms.dto.UpdateServiceRecordRequestDto;
import com.prathmesh.vsms.dto.UpdateServiceStatusResponseDto;
import com.prathmesh.vsms.entity.ServiceRecord;
import com.prathmesh.vsms.enums.ServiceStatus;
import com.prathmesh.vsms.exception.ResourceNotFoundException;
import com.prathmesh.vsms.repository.ServiceRecordRepository;
import com.prathmesh.vsms.service.AdminServiceRecordService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class AdminServiceRecordServiceImp implements AdminServiceRecordService {
  private ServiceRecordRepository serviceRecordRepository;
      public   AdminServiceRecordServiceImp (ServiceRecordRepository serviceRecordRepository){
          this.serviceRecordRepository = serviceRecordRepository;
      }
    @Override
    public List<BookedServiceResponseDto> getBookedServiceRecord() {
          //serviceRecordRepository.findBy
                   List<ServiceRecord> serviceRecords = serviceRecordRepository.findAll();
            List<BookedServiceResponseDto> listOfBookedServiceRecord = new ArrayList<>();
            for (ServiceRecord serviceRecord : serviceRecords){
                BookedServiceResponseDto dto = new BookedServiceResponseDto();
                dto.setServiceID(serviceRecord.getServiceRecordId());
                dto.setVehicleNumber(serviceRecord.getVehicle().getVehicleNumber());
                dto.setServiceStatus(serviceRecord.getServiceStatus());
                dto.setCustomerName(serviceRecord.getVehicle().getCustomer().getName());
                dto.setServiceType(serviceRecord.getServiceType());
                listOfBookedServiceRecord.add(dto);
            }


        return listOfBookedServiceRecord;
    }

    @Override
    public AdminServiceRecordResponseByIdDto getBookedServiceRecordById(Long id) {
        ServiceRecord serviceRecord = serviceRecordRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Cannot find service record by id."));
        AdminServiceRecordResponseByIdDto dto = new AdminServiceRecordResponseByIdDto();
        dto.setServiceId(serviceRecord.getServiceRecordId());
        dto.setCustomerRequest(serviceRecord.getDescription());
        dto.setCost(serviceRecord.getCost());
        dto.setServiceType(serviceRecord.getServiceType());
        dto.setVehicleNumber(serviceRecord.getVehicle().getVehicleNumber());
        dto.setCustomerName(serviceRecord.getVehicle().getCustomer().getName());
        dto.setServiceStatus(serviceRecord.getServiceStatus());
         return dto;

    }
        public UpdateServiceStatusResponseDto startService(Long id){
          ServiceRecord serviceRecord=  serviceRecordRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cannot find service record by id."));
                    serviceRecord.setServiceStatus(ServiceStatus.IN_PROGRESS);
            ServiceRecord updatedServiceRecord =  serviceRecordRepository.save(serviceRecord);
            UpdateServiceStatusResponseDto dto = new UpdateServiceStatusResponseDto();
            dto.setServiceId(updatedServiceRecord.getServiceRecordId());
            dto.setServiceStatus(updatedServiceRecord.getServiceStatus());
            return dto;
        }
    public AdminServiceRecordResponseByIdDto updateServiceRecord(
            Long id,
            UpdateServiceRecordRequestDto request){
        ServiceRecord serviceRecord=  serviceRecordRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cannot find service record by id."));
        serviceRecord.setDescription(
                "Customer Request:\n"
                        + serviceRecord.getDescription()
                        + "\n\nMechanic Notes:\n"
                        + request.getMechanicNotes()
        );
        serviceRecord.setCost(request.getCost());
        serviceRecord.setServiceStatus(ServiceStatus.COMPLETE);
        ServiceRecord updatedServiceRecord = serviceRecordRepository.save(serviceRecord);
        AdminServiceRecordResponseByIdDto dto = new AdminServiceRecordResponseByIdDto();
        dto.setServiceId(updatedServiceRecord.getServiceRecordId());
        dto.setCustomerRequest(updatedServiceRecord.getDescription());
        dto.setCost(updatedServiceRecord.getCost());
        dto.setServiceType(updatedServiceRecord.getServiceType());
        dto.setVehicleNumber(updatedServiceRecord.getVehicle().getVehicleNumber());
        dto.setCustomerName(updatedServiceRecord.getVehicle().getCustomer().getName());
        dto.setServiceStatus(updatedServiceRecord.getServiceStatus());
          return dto;
    }

}
