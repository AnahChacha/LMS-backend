package com.laundry.lms.reports;

import com.laundry.lms.customers.model.CustomerModel;
import com.laundry.lms.customers.repository.CustomerRepository;
import com.laundry.lms.laundryServices.model.LaundryModel;
import com.laundry.lms.laundryServices.repository.LaundryRepository;
import com.laundry.lms.staffs.model.StaffModel;
import com.laundry.lms.staffs.repository.StaffRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReportServiceImpl implements ReportService{
    private final CustomerRepository customerRepository;
    private final LaundryRepository laundryRepository;
    private final StaffRepository staffRepository;

    @Override
    public List<CustomerModel> filterCustomerByDateRange(LocalDate startDate, LocalDate endDate) {
        return customerRepository.findCustomerByCreatedDateBetween(startDate.atStartOfDay(), endDate.atTime(LocalTime.MAX));
    }

    @Override
    public List<StaffModel> filterStaffByDateRange(LocalDate startDate, LocalDate endDate) {
        LocalDateTime startLocalDateTime=startDate.atStartOfDay();
        LocalDateTime endLocalDateTime=endDate.atTime(LocalTime.MAX);
        return staffRepository.findStaffByCreatedDateBetween(startLocalDateTime,endLocalDateTime);
    }

    @Override
    public List<StaffModel> filterStaffByDateRangeAndGender(LocalDate startDate, LocalDate endDate, String gender) {
        LocalDateTime startLocalDateTime=startDate.atStartOfDay();
        LocalDateTime endLocalDateTime=endDate.atTime(LocalTime.MAX);
        return staffRepository.findStaffsByCreatedDateBetweenAndGender(startLocalDateTime,endLocalDateTime,gender);
    }

    @Override
    public List<StaffModel> filterStaffByDateRangeAndName(LocalDate startDate, LocalDate endDate, String name) {
        LocalDateTime startLocalDateTime=startDate.atStartOfDay();
        LocalDateTime endLocalDateTime=endDate.atTime(LocalTime.MAX);
        return staffRepository.findStaffByCreatedDateBetweenAndName(startLocalDateTime,endLocalDateTime,name);
    }

    @Override
    public List<LaundryModel> filterServicesByDateRange(LocalDate startDate, LocalDate endDate) {
        LocalDateTime startLocalDateTime=startDate.atStartOfDay();
        LocalDateTime endLocalDateTime=endDate.atTime(LocalTime.MAX);
        return laundryRepository.findServicesByCreatedDateBetween(startLocalDateTime,endLocalDateTime);
    }
}
