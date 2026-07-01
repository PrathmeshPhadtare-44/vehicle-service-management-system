package com.prathmesh.vsms.service;

import com.prathmesh.vsms.dto.AdminServiceRecordResponseByIdDto;
import com.prathmesh.vsms.dto.BookedServiceResponseDto;

import java.util.List;

public interface AdminServiceRecordService {
    public List<BookedServiceResponseDto>  getBookedServiceRecord();
    public AdminServiceRecordResponseByIdDto getBookedServiceRecordById(Long id);
}
