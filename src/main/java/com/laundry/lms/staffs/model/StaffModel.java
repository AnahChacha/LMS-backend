package com.laundry.lms.staffs.model;

import com.laundry.lms.baseEntity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "staffs_tb")
public class StaffModel extends BaseEntity {
    @Column(name = "staff_id")
    private String staffId;

    @Column(name = "staff_name")
    private String name;

    @Column(name = "staff_gender")
    private String gender;

    @Column(name = "phone_no")
    private String phoneNo;

    @Column(name = "email_address")
    private String email;
}
