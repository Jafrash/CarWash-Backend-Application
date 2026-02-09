package com.example.carwash.dto;

import com.example.carwash.model.PackageType;
import com.example.carwash.model.ServiceType;
import lombok.Data;
import java.time.LocalDate;

@Data
public class ServiceRequest {
    private Long customerId;
    private PackageType packageType;
    private ServiceType serviceType;
    private LocalDate startDate;
}
