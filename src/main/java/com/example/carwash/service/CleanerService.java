package com.example.carwash.service;

import com.example.carwash.model.Cleaner;
import com.example.carwash.repository.CleanerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CleanerService {
    private final CleanerRepository cleanerRepository;

    public Cleaner createCleaner(Cleaner cleaner) {
        return cleanerRepository.save(cleaner);
    }

    public List<Cleaner> getAllCleaners() {
        return cleanerRepository.findAll();
    }

    public List<Cleaner> getAvailableCleanersByArea(String area) {
        return cleanerRepository.findByAreaAndAvailable(area, true);
    }

    public Cleaner updateCleaner(Long id, Cleaner cleaner) {
        Cleaner existing = cleanerRepository.findById(id).orElseThrow();
        existing.setName(cleaner.getName());
        existing.setEmail(cleaner.getEmail());
        existing.setPhone(cleaner.getPhone());
        existing.setArea(cleaner.getArea());
        existing.setExperience(cleaner.getExperience());
        existing.setSalary(cleaner.getSalary());
        existing.setAvailable(cleaner.getAvailable());
        return cleanerRepository.save(existing);
    }

    public void deleteCleaner(Long id) {
        cleanerRepository.deleteById(id);
    }
}
