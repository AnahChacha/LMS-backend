package com.laundry.lms.customers.service;

import com.laundry.lms.customers.dto.CustomerDto;
import com.laundry.lms.customers.model.CustomerModel;

import java.util.List;
import java.util.UUID;

public interface CustomerService {
    CustomerModel createCustomer(CustomerDto customerDto);

    CustomerModel updateCustomer(CustomerDto customerDto);

    List<CustomerModel>getAllCustomers();

    String deleteCustomer(UUID publicId);

    CustomerModel findCustomerById(String customerId);
}
