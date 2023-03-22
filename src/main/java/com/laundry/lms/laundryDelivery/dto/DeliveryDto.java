package com.laundry.lms.laundryDelivery.dto;

import com.laundry.lms.enums.DeliveryStatus;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.UUID;

@Data
public class DeliveryDto {
    private UUID publicId;
    @Enumerated(EnumType.STRING)
    private DeliveryStatus deliveryStatus;
}
