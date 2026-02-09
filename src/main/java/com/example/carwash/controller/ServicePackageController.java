package com.example.carwash.controller;

import com.example.carwash.dto.ServiceRequest;
import com.example.carwash.model.ServicePackage;
import com.example.carwash.service.ServicePackageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/services")
@RequiredArgsConstructor
public class ServicePackageController {
    private final ServicePackageService servicePackageService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ServicePackage createServicePackage(@RequestBody ServiceRequest request) {
        return servicePackageService.createServicePackage(request);
    }

    @GetMapping
    public List<ServicePackage> getAllServicePackages() {
        return servicePackageService.getAllServicePackages();
    }
}
