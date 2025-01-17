package com.employee.management.region.service;

import com.employee.management.region.model.Region;
import com.employee.management.region.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegionService {

    @Autowired
    private final RegionRepository regionRepository;

    public RegionService(RegionRepository regionRepository) {
        this.regionRepository = regionRepository;
    }

    public Region createRegion(Region region) {
        return regionRepository.save(region);
    }


    public Optional<Region> getRegionById(Long id) {
        return regionRepository.findById(id);
    }

    public List<Region> getAllRegions() {
        return regionRepository.findAll();
    }
}
