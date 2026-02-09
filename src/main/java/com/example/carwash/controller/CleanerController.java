package com.example.carwash.controller;

import com.example.carwash.model.Cleaner;
import com.example.carwash.service.CleanerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/cleaners")
@RequiredArgsConstructor
public class CleanerController {
    private final CleanerService cleanerService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cleaner createCleaner(@RequestBody Cleaner cleaner) {
        return cleanerService.createCleaner(cleaner);
    }

    @GetMapping
    public List<Cleaner> getAllCleaners() {
        return cleanerService.getAllCleaners();
    }

    @GetMapping("/area/{area}")
    public List<Cleaner> getAvailableCleanersByArea(@PathVariable String area) {
        return cleanerService.getAvailableCleanersByArea(area);
    }

    @PutMapping("/{id}")
    public Cleaner updateCleaner(@PathVariable Long id, @RequestBody Cleaner cleaner) {
        return cleanerService.updateCleaner(id, cleaner);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCleaner(@PathVariable Long id) {
        cleanerService.deleteCleaner(id);
    }
}
