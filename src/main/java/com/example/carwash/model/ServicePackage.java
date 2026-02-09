package com.example.carwash.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Data
public class ServicePackage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    private Customer customer;
    
    @ManyToOne
    private Cleaner cleaner;
    
    @Enumerated(EnumType.STRING)
    private PackageType packageType;
    
    @Enumerated(EnumType.STRING)
    private ServiceType serviceType;
    
    private LocalDate startDate;
    private LocalDate endDate;
    
    @Enumerated(EnumType.STRING)
    private ServiceStatus status = ServiceStatus.ACTIVE;
}
