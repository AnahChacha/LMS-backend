package com.laundry.lms.laundryServices.service;

import com.laundry.lms.exception.IllegalArgumentExceptionHandler;
import com.laundry.lms.laundryServices.dto.LaundryDto;
import com.laundry.lms.laundryServices.model.LaundryModel;
import com.laundry.lms.laundryServices.repository.LaundryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class LaundryServiceImpl implements LaundryService{
    private final LaundryRepository laundryRepository;

    @Override
    public LaundryModel createLaundry(LaundryDto laundryDto) {
        LaundryModel laundry=new LaundryModel();
        laundry.setName(laundryDto.getName());
        laundry.setPrice(laundryDto.getPrice());
        laundry.setServiceId(UUID.randomUUID().toString());
        laundry.setDuration(laundryDto.getDuration());
        return laundryRepository.save(laundry);
    }

    @Override
    public LaundryModel updateLaundry(LaundryDto laundryDto) {
        LaundryModel laundry=laundryRepository.findByPublicId(laundryDto.getPublicId()).orElseThrow(() -> new IllegalArgumentExceptionHandler("laundry service not found"));
        laundry.setName(laundryDto.getName());
        laundry.setPrice(laundryDto.getPrice());
        laundry.setDuration(laundryDto.getDuration());
        return laundryRepository.save(laundry);
    }

    @Override
    public List<LaundryModel> getAllLaundryServices() {
        return laundryRepository.findAll();
    }

    @Override
    public String deleteLaundry(UUID publicId) {
        LaundryModel laundry=laundryRepository.findByPublicId(publicId).orElseThrow(() -> new IllegalArgumentExceptionHandler("laundry service was not found"));
        laundryRepository.delete(laundry);
        return ("laundry service was deleted successfully");
    }

    @Override
    public LaundryModel findServiceById(String serviceId) {
        LaundryModel laundry=laundryRepository.findByServiceId(serviceId).orElseThrow(() -> new IllegalArgumentExceptionHandler("laundry service was not found"));
        return laundry;
    }
}
