package com.laundry.lms.laundryDelivery.service;

import com.laundry.lms.laundryDelivery.dto.DeliveryDto;
import com.laundry.lms.laundryDelivery.model.DeliveryModel;

public interface DeliveryService {
    DeliveryModel createStatus(DeliveryDto deliveryDto);
}
