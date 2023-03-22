package com.laundry.lms.customers.model;

import com.laundry.lms.baseEntity.BaseEntity;
import com.laundry.lms.laundryDelivery.model.DeliveryModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customers_tb")
public class CustomerModel extends BaseEntity {
    @Column(name = "customer_id")
    private String customerId;

    @Column(name = "customer_name")
    private String name;

    @Column(name = "customer_gender")
    private String gender;

    @Column(name = "home_address")
    private String address;

    @Column(name = "phone_no")
    private String phoneNo;

    @Column(name = "email_address")
    private String email;

    @OneToOne
    @JoinColumn(name = "status_id")
    private DeliveryModel deliveryModel;


}
