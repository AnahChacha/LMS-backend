package com.laundry.lms.laundryDelivery.model;

import com.laundry.lms.baseEntity.BaseEntity;
import com.laundry.lms.customers.model.CustomerModel;
import com.laundry.lms.enums.DeliveryStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "status_tb")
public class DeliveryModel extends BaseEntity {
    @Column(name = "delivery_status")
    private DeliveryStatus deliveryStatus;
    @Column(name = "status_id")
    private String statusId;
    @OneToOne(mappedBy = "deliveryModel")
    private CustomerModel customerModel;
}
