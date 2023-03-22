package com.laundry.lms.staffs.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class StaffDto {
    private UUID publicId;
    private String name;
    private String gender;
    private String phoneNo;
    private String email;
}
