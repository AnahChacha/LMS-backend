package com.laundry.lms.staffs.controller;

import com.laundry.lms.staffs.dto.StaffDto;
import com.laundry.lms.staffs.model.StaffModel;
import com.laundry.lms.staffs.service.StaffService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "staff")
@RequiredArgsConstructor
public class StaffController {
    private final StaffService staffService;

    @PostMapping(value = "/createStaff")
    public ResponseEntity<StaffModel>createStaff(StaffDto staffDto){
      return ResponseEntity.ok(staffService.createStaff(staffDto));
    }

    @PutMapping(value = "/updateStaff")
    public ResponseEntity<StaffModel>updateStaff(StaffDto staffDto){
      return ResponseEntity.ok(staffService.updateStaff(staffDto));
    }

    @GetMapping(value = "/getAllStaffs")
    public ResponseEntity<List<StaffModel>>findAllStaffs(){
        return ResponseEntity.ok(staffService.getAllStaffs());
    }

    @DeleteMapping(value = "/deleteStaff/{publicId}")
    public ResponseEntity<String>deleteStaff(@PathVariable UUID publicId){
        return ResponseEntity.ok(staffService.deleteStaff(publicId));
    }

    @GetMapping(value = "/findStaffById/{staffId}")
    public ResponseEntity<StaffModel>findStaffById(@PathVariable String staffId){
      return ResponseEntity.ok(staffService.findStaffById(staffId));
    }
}
