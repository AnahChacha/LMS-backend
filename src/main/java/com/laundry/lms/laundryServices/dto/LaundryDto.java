package com.laundry.lms.laundryServices.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class LaundryDto {
    private UUID publicId;
    private String name;
    private int price;
    private String duration;

}
