package com.laundry.lms.reports;

import com.laundry.lms.customers.model.CustomerModel;
import com.laundry.lms.laundryServices.model.LaundryModel;
import com.laundry.lms.staffs.model.StaffModel;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(value = "reports")
@RequiredArgsConstructor
public class ReportRestController {
    private final ReportService reportService;

    @GetMapping(value = "/findCustomersByDateRange")
    public List<CustomerModel> findCustomerByDateRange(@RequestParam(value = "startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
                                                       @RequestParam(value = "endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        return reportService.filterCustomerByDateRange(startDate, endDate);
    }

    @GetMapping(value = "/findStaffsByDateRange")
    public ResponseEntity<List<StaffModel>> findStaffs(@RequestParam(value = "startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
                                                       @RequestParam(value = "endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate,
                                                       @RequestParam(value = "gender") String gender,
                                                       @RequestParam(value = "name") String name) {
        List<StaffModel> staffResult;

        if (!ObjectUtils.isEmpty(startDate) && !ObjectUtils.isEmpty(endDate)&&!ObjectUtils.isEmpty(gender)) {
            staffResult = reportService.filterStaffByDateRangeAndGender(startDate, endDate,gender);
        } else if (!ObjectUtils.isEmpty(startDate)&&!ObjectUtils.isEmpty(endDate)) {
            staffResult=reportService.filterStaffByDateRangeAndName(startDate, endDate,name);
        } else {
            staffResult = reportService.filterStaffByDateRange(startDate,endDate);
        }
        return ResponseEntity.status(HttpStatus.OK).body(staffResult);
    }

    @GetMapping(value = "/findServicesByDateRange")
    public ResponseEntity<List<LaundryModel>> findServicesByDateRange(@RequestParam(value = "startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
                                                                      @RequestParam(value = "endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        List<LaundryModel> servicesResults;
        if (!ObjectUtils.isEmpty(startDate) && !ObjectUtils.isEmpty(endDate)) {
            servicesResults = reportService.filterServicesByDateRange(startDate, endDate);
        } else {
            servicesResults = null;
        }
        return ResponseEntity.ok(servicesResults);
    }

}
