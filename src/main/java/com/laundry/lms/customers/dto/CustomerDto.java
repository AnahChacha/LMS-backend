package com.laundry.lms.customers.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class CustomerDto {
    private UUID publicId;
    private String name;
    private String gender;
    private String address;
    private String phoneNo;
    private String email;

}
