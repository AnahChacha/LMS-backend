package com.laundry.lms.laundryDelivery.service;

import com.laundry.lms.enums.DeliveryStatus;
import com.laundry.lms.laundryDelivery.dto.DeliveryDto;
import com.laundry.lms.laundryDelivery.model.DeliveryModel;
import com.laundry.lms.laundryDelivery.repository.DeliveryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DeliveryServiceImpl implements DeliveryService{
    private final DeliveryRepository deliveryRepository;

    @Override
    public DeliveryModel createStatus(DeliveryDto deliveryDto) {
        DeliveryModel deliveryStatus=new DeliveryModel();
        deliveryStatus.setStatusId(UUID.randomUUID().toString());
//        deliveryStatus.setDeliveryStatus(DeliveryStatus.Delivered);
        deliveryStatus.setDeliveryStatus(DeliveryStatus.OnDelivery);
        return deliveryRepository.save(deliveryStatus);
    }
}
