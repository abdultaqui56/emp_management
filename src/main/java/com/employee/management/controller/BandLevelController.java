package com.employee.management.controller;

import com.employee.management.bandLevel.model.BandLevel;
import com.employee.management.bandLevel.service.BandLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/band-levels")
public class BandLevelController {

    @Autowired
    private final BandLevelService bandLevelService;

    public BandLevelController(BandLevelService bandLevelService) {
        this.bandLevelService = bandLevelService;
    }

    @PostMapping
    public ResponseEntity<BandLevel> createBandLevel(@RequestBody BandLevel bandLevel) {
        // You can manually ensure valid BandLevel objects with correct Band and Level
        BandLevel savedBandLevel = bandLevelService.createBandLevel(bandLevel);
        return ResponseEntity.ok(savedBandLevel);
    }

    @GetMapping
    public ResponseEntity<List<BandLevel>> getAllBandLevels() {
        return ResponseEntity.ok(bandLevelService.getAllBandLevels());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BandLevel> getBandLevelById(@PathVariable Long id) {
        return bandLevelService.getBandLevelById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<BandLevel> updateBandLevel(@PathVariable Long id, @RequestBody BandLevel bandLevelDetails) {
        BandLevel updatedBandLevel = bandLevelService.updateBandLevel(id, bandLevelDetails);
        return ResponseEntity.ok(updatedBandLevel);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBandLevel(@PathVariable Long id) {
        bandLevelService.deleteBandLevel(id);
        return ResponseEntity.noContent().build();
    }
}
