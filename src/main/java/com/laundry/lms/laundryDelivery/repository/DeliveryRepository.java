package com.laundry.lms.laundryDelivery.repository;

import com.laundry.lms.laundryDelivery.model.DeliveryModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryRepository extends JpaRepository<DeliveryModel,String> {

}
