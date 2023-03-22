package com.laundry.lms.laundryServices.controller;

import com.laundry.lms.laundryServices.dto.LaundryDto;
import com.laundry.lms.laundryServices.model.LaundryModel;
import com.laundry.lms.laundryServices.service.LaundryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping(value = "laundry")
@RequiredArgsConstructor
public class LaundryController {
    private final LaundryService laundryService;

    @PostMapping(value = "/createServices")
    public ResponseEntity<LaundryModel>createServices(@RequestBody LaundryDto laundryDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(laundryService.createLaundry(laundryDto));
    }

    @PutMapping(value = "/updateService")
    public ResponseEntity<LaundryModel>updateService(@RequestBody LaundryDto laundryDto){
        return ResponseEntity.status(HttpStatus.OK).body(laundryService.updateLaundry(laundryDto));
    }

    @GetMapping(value = "/findAllServices")
    public ResponseEntity<List<LaundryModel>>findAllServices(){
        return ResponseEntity.status(HttpStatus.OK).body(laundryService.getAllLaundryServices());
    }

    @DeleteMapping(value = "/deleteService/{publicId}")
    public ResponseEntity<String>deleteService(@PathVariable UUID publicId){
       return ResponseEntity.status(HttpStatus.OK).body(laundryService.deleteLaundry(publicId));
    }

    @GetMapping(value = "/findServiceById/{serviceId}")
    public ResponseEntity<LaundryModel>findServiceById(@PathVariable String serviceId){
       return ResponseEntity.ok(laundryService.findServiceById(serviceId));
    }
}
