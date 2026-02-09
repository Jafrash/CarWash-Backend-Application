package com.example.carwash.service;

import com.example.carwash.dto.ServiceRequest;
import com.example.carwash.exception.ServiceUnavailableException;
import com.example.carwash.model.*;
import com.example.carwash.repository.ServicePackageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ServicePackageService {
    private final ServicePackageRepository servicePackageRepository;
    private final CustomerService customerService;
    private final CleanerService cleanerService;

    public ServicePackage createServicePackage(ServiceRequest request) {
        Customer customer = customerService.getCustomerById(request.getCustomerId());
        
        List<Cleaner> availableCleaners = cleanerService.getAvailableCleanersByArea(customer.getArea());
        
        if (availableCleaners.isEmpty()) {
            throw new ServiceUnavailableException("No cleaners available in area: " + customer.getArea());
        }
        
        Cleaner assignedCleaner = availableCleaners.get(0);
        
        ServicePackage servicePackage = new ServicePackage();
        servicePackage.setCustomer(customer);
        servicePackage.setCleaner(assignedCleaner);
        servicePackage.setPackageType(request.getPackageType());
        servicePackage.setServiceType(request.getServiceType());
        servicePackage.setStartDate(request.getStartDate());
        servicePackage.setEndDate(calculateEndDate(request.getStartDate(), request.getPackageType()));
        
        return servicePackageRepository.save(servicePackage);
    }

    public List<ServicePackage> getAllServicePackages() {
        return servicePackageRepository.findAll();
    }

    public ServicePackage updateServicePackage(Long id, ServiceRequest request) {
        ServicePackage existing = servicePackageRepository.findById(id).orElseThrow();
        existing.setPackageType(request.getPackageType());
        existing.setServiceType(request.getServiceType());
        existing.setStartDate(request.getStartDate());
        existing.setEndDate(calculateEndDate(request.getStartDate(), request.getPackageType()));
        return servicePackageRepository.save(existing);
    }

    public void deleteServicePackage(Long id) {
        servicePackageRepository.deleteById(id);
    }

    private LocalDate calculateEndDate(LocalDate startDate, PackageType packageType) {
        return switch (packageType) {
            case WEEKLY -> startDate.plusWeeks(1);
            case MONTHLY -> startDate.plusMonths(1);
            case YEARLY -> startDate.plusYears(1);
        };
    }
}
