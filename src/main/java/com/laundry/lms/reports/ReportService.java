package com.laundry.lms.reports;

import com.laundry.lms.customers.model.CustomerModel;
import com.laundry.lms.laundryServices.model.LaundryModel;
import com.laundry.lms.staffs.model.StaffModel;

import java.time.LocalDate;
import java.util.List;

public interface ReportService {
    List<CustomerModel>filterCustomerByDateRange(LocalDate startDate, LocalDate endDate);
    List<StaffModel>filterStaffByDateRange(LocalDate startDate,LocalDate endDate);
    List<StaffModel>filterStaffByDateRangeAndGender(LocalDate startDate,LocalDate endDate,String gender);
    List<StaffModel>filterStaffByDateRangeAndName(LocalDate startDate,LocalDate endDate,String name);
    List<LaundryModel>filterServicesByDateRange(LocalDate startDate,LocalDate endDate);
}
