package com.laundry.lms.laundryDelivery.controller;

import com.laundry.lms.laundryDelivery.dto.DeliveryDto;
import com.laundry.lms.laundryDelivery.model.DeliveryModel;
import com.laundry.lms.laundryDelivery.service.DeliveryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "status")
@RequiredArgsConstructor
public class DeliveryController {
    private final DeliveryService deliveryService;

    @PostMapping(value = "/createStatus")
    public ResponseEntity<DeliveryModel>createStatus(@RequestBody DeliveryDto deliveryDto){
       return ResponseEntity.ok(deliveryService.createStatus(deliveryDto));
    }
}
