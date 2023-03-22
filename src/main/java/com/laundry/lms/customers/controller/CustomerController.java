package com.laundry.lms.customers.controller;

import com.laundry.lms.customers.dto.CustomerDto;
import com.laundry.lms.customers.model.CustomerModel;
import com.laundry.lms.customers.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "customer")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping(value = "/createCustomer")
    public ResponseEntity<CustomerModel>createCustomer(@RequestBody CustomerDto customerDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(customerService.createCustomer(customerDto));
    }

    @PutMapping(value = "/updateCustomer")
    public ResponseEntity<CustomerModel>updateCustomer(@RequestBody CustomerDto customerDto){
        return ResponseEntity.ok(customerService.updateCustomer(customerDto));
    }

    @GetMapping(value = "/findAllCustomers")
    public ResponseEntity<List<CustomerModel>>findAllCustomers(){
        return ResponseEntity.status(HttpStatus.OK).body(customerService.getAllCustomers());
    }

    @DeleteMapping(value = "/deleteCustomer/{publicId}")
    public ResponseEntity<String>deleteCustomer(@PathVariable UUID publicId){
        return ResponseEntity.status(HttpStatus.OK).body(customerService.deleteCustomer(publicId));
    }

    @GetMapping(value = "/getCustomerById/{customerId}")
    public ResponseEntity<CustomerModel>findCustomerById(@PathVariable String customerId){
       return ResponseEntity.status(HttpStatus.OK).body(customerService.findCustomerById(customerId));
    }

}