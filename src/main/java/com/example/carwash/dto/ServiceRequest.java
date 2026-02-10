package com.example.carwash.dto;

import com.example.carwash.model.PackageType;
import com.example.carwash.model.ServiceType;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Data
@Getter
@Setter
public class ServiceRequest {
    private Long customerId;
    private PackageType packageType;
    private ServiceType serviceType;
    private LocalDate startDate;
    private LocalDate endDate;
}
