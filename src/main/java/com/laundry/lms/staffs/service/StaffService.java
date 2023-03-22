package com.laundry.lms.staffs.service;

import com.laundry.lms.staffs.dto.StaffDto;
import com.laundry.lms.staffs.model.StaffModel;

import java.util.List;
import java.util.UUID;

public interface StaffService {
    StaffModel createStaff(StaffDto staffDto);

    StaffModel updateStaff(StaffDto staffDto);

    List<StaffModel>getAllStaffs();

    String deleteStaff(UUID publicId);

    StaffModel findStaffById(String staffId);
}
