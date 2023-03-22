package com.laundry.lms.staffs.service;

import com.laundry.lms.exception.IllegalArgumentExceptionHandler;
import com.laundry.lms.laundryServices.model.LaundryModel;
import com.laundry.lms.staffs.dto.StaffDto;
import com.laundry.lms.staffs.model.StaffModel;
import com.laundry.lms.staffs.repository.StaffRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class StaffServiceImpl implements StaffService{
    private final StaffRepository staffRepository;

    @Override
    public StaffModel createStaff(StaffDto staffDto) {
        StaffModel staff=new StaffModel();
        staff.setStaffId(UUID.randomUUID().toString());
        staff.setName(staffDto.getName());
        staff.setPhoneNo(staffDto.getPhoneNo());
        staff.setEmail(staffDto.getEmail());
        staff.setGender(staffDto.getGender());
        return staffRepository.save(staff);
    }

    @Override
    public StaffModel updateStaff(StaffDto staffDto) {
        StaffModel staff=staffRepository.findByPublicId(staffDto.getPublicId()).orElseThrow(() -> new IllegalArgumentExceptionHandler("staff was not found"));
        staff.setName(staffDto.getName());
        staff.setPhoneNo(staffDto.getPhoneNo());
        staff.setEmail(staffDto.getEmail());
        staff.setGender(staffDto.getGender());
        return staffRepository.save(staff);
    }

    @Override
    public List<StaffModel> getAllStaffs() {
        return staffRepository.findAll();
    }

    @Override
    public String deleteStaff(UUID publicId) {
        StaffModel staff=staffRepository.findByPublicId(publicId).orElseThrow(() -> new IllegalArgumentExceptionHandler("staff was not found"));
        staffRepository.delete(staff);
        return ("staff was delete successfully");
    }

    @Override
    public StaffModel findStaffById(String staffId) {
        StaffModel staff=staffRepository.findByStaffId(staffId).orElseThrow(() -> new IllegalArgumentExceptionHandler("staff was not found"));
        return staff;
    }
}
