package com.laundry.lms.laundryServices.service;

import com.laundry.lms.laundryServices.dto.LaundryDto;
import com.laundry.lms.laundryServices.model.LaundryModel;

import java.util.List;
import java.util.UUID;

public interface LaundryService {
    LaundryModel createLaundry(LaundryDto laundryDto);

    LaundryModel updateLaundry(LaundryDto laundryDto);

    List<LaundryModel>getAllLaundryServices();

    String deleteLaundry(UUID publicId);

    LaundryModel findServiceById(String serviceId);
}
