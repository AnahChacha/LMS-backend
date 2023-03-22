package com.laundry.lms.customers.repository;

import com.laundry.lms.customers.model.CustomerModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CustomerRepository extends JpaRepository<CustomerModel,String> {

    Optional<CustomerModel>findByPublicId(UUID publicId);

    Optional<CustomerModel>findByCustomerId(String customerId);

   List<CustomerModel>findCustomerByCreatedDateBetween(LocalDateTime startDate,LocalDateTime endDate);
}
