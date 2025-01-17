package com.employee.management.bandLevel.service;

import com.employee.management.bandLevel.model.BandLevel;
import com.employee.management.bandLevel.repository.BandLevelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BandLevelService {

    @Autowired
    private final BandLevelRepository bandLevelRepository;

    public BandLevelService(BandLevelRepository bandLevelRepository) {
        this.bandLevelRepository = bandLevelRepository;
    }

    public BandLevel createBandLevel(BandLevel bandLevel) {
        // Check if the BandLevel already exists
        return bandLevelRepository.save(bandLevel); // Save new or existing BandLevel
    }

    public List<BandLevel> getAllBandLevels() {
        return bandLevelRepository.findAll();
    }

    public Optional<BandLevel> getBandLevelById(Long id) {
        return bandLevelRepository.findById(id);
    }

    public BandLevel updateBandLevel(Long id, BandLevel bandLevelDetails) {
        BandLevel bandLevel = bandLevelRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("BandLevel not found for id: " + id));

        bandLevel.setBandName(bandLevelDetails.getBandName());
        bandLevel.setLevel(bandLevelDetails.getLevel());

        return bandLevelRepository.save(bandLevel);
    }

    public void deleteBandLevel(Long id) {
        BandLevel bandLevel = bandLevelRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("BandLevel not found for id: " + id));
        bandLevelRepository.delete(bandLevel);
    }
}

