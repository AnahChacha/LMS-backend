package com.laundry.lms.laundryServices.repository;

import com.laundry.lms.laundryServices.model.LaundryModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface LaundryRepository extends JpaRepository<LaundryModel,String> {
    Optional<LaundryModel>findByPublicId(UUID publicId);
    Optional<LaundryModel>findByServiceId(String serviceId);
    List<LaundryModel>findServicesByCreatedDateBetween(LocalDateTime startDate,LocalDateTime endDate);
}
