package com.example.carwash.repository;

import com.example.carwash.model.Cleaner;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface CleanerRepository extends JpaRepository<Cleaner, Long> {
    List<Cleaner> findByAreaAndAvailable(String area, boolean available);
}
