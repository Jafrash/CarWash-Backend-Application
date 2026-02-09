package com.example.carwash.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Cleaner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    
    @Column(unique = true)
    private String email;
    
    @Column(unique = true)
    private String phone;
    
    private String area;
    private Integer experience;
    private Double salary;
    private Boolean available = true;
}
