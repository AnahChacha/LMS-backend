package com.laundry.lms.customers.service;

import com.laundry.lms.customers.dto.CustomerDto;
import com.laundry.lms.customers.model.CustomerModel;
import com.laundry.lms.customers.repository.CustomerRepository;
import com.laundry.lms.exception.IllegalArgumentExceptionHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService{
    private final CustomerRepository customerRepository;

    @Override
    public CustomerModel createCustomer(CustomerDto customerDto) {

        try {

            CustomerModel customer = new CustomerModel();
            customer.setCustomerId(UUID.randomUUID().toString());
            customer.setName(customerDto.getName());
            customer.setEmail(customerDto.getEmail());
            customer.setAddress(customerDto.getAddress());
            customer.setPhoneNo(customerDto.getPhoneNo());
            customer.setGender(customerDto.getGender());
            return customerRepository.save(customer);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public CustomerModel updateCustomer(CustomerDto customerDto) {
            CustomerModel customer = customerRepository.findByPublicId(customerDto.getPublicId()).orElseThrow(() ->new IllegalArgumentExceptionHandler("customer was not found"));
            customer.setGender(customerDto.getGender());
            customer.setName(customerDto.getName());
            customer.setEmail(customerDto.getEmail());
            customer.setAddress(customerDto.getAddress());
            customer.setPhoneNo(customerDto.getPhoneNo());
            return customerRepository.save(customer);
    }

    @Override
    public List<CustomerModel> getAllCustomers() {
            return customerRepository.findAll();
    }

    @Override
    public String deleteCustomer(UUID publicId) {
            CustomerModel customer=customerRepository.findByPublicId(publicId).orElseThrow(() -> new IllegalArgumentExceptionHandler("customer was not found"));
            customerRepository.delete(customer);
            return ("customer was deleted successfully");
    }

    @Override
    public CustomerModel findCustomerById(String customerId) {

        CustomerModel customer = customerRepository.findByCustomerId(customerId).orElseThrow(() -> new IllegalArgumentExceptionHandler("customer was not found"));
        return customer;
    }
}
