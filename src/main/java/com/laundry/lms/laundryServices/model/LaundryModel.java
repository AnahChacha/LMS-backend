package com.laundry.lms.laundryServices.model;

import com.laundry.lms.baseEntity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "services_tb")
public class LaundryModel extends BaseEntity {
    @Column(name = "service_id")
    private String serviceId;
    @Column(name = "service_name")
    private String name;
    @Column(name = "service_price")
    private int price;
    @Column(name = "service_duration")
    private String duration;
}
