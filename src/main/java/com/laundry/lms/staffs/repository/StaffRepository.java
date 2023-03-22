package com.laundry.lms.staffs.repository;

import com.laundry.lms.laundryServices.model.LaundryModel;
import com.laundry.lms.staffs.model.StaffModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface StaffRepository extends JpaRepository<StaffModel,String> {
    Optional<StaffModel>findByPublicId(UUID publicId);
    Optional<StaffModel>findByStaffId(String staffId);
    List<StaffModel>findStaffByCreatedDateBetween(LocalDateTime startDate,LocalDateTime endDate);
    List<StaffModel>findStaffsByCreatedDateBetweenAndGender(LocalDateTime startDate,LocalDateTime endDate,String gender);
    List<StaffModel>findStaffByCreatedDateBetweenAndName(LocalDateTime startDate,LocalDateTime endDate,String name);
}
