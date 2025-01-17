package com.employee.management.controller;

import com.employee.management.region.model.Region;
import com.employee.management.region.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/regions")
public class RegionController {

    @Autowired
    private final RegionService regionService;

    public RegionController(RegionService regionService) {
        this.regionService = regionService;
    }

    @PostMapping
    public ResponseEntity<Region> createRegion(@RequestBody Region region) {
        Region savedRegion = regionService.createRegion(region);
        return ResponseEntity.ok(savedRegion);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Region> getRegionById(@PathVariable Long id) {
        return regionService.getRegionById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Region>> getAllRegions() {
        return ResponseEntity.ok(regionService.getAllRegions());
    }
}
