package com.employee.management.bandAndRole.service;

import com.employee.management.bandAndRole.model.BandAndRole;
import com.employee.management.bandAndRole.Repository.BandAndRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BandAndRoleService {


    private final BandAndRoleRepository bandAndRoleRepository;

    public BandAndRoleService(BandAndRoleRepository bandAndRoleRepository) {
      this.bandAndRoleRepository = bandAndRoleRepository; }

    public BandAndRole createBandAndRole(BandAndRole bandAndRole) {
        //  System.out.println("Saved BandAndRole: " + savedBandAndRole);  // Log the saved object
        return bandAndRoleRepository.save(bandAndRole);
    }


    public List<BandAndRole> getAllBandAndRoles() {
        return bandAndRoleRepository.findAll();
    }

    public Optional<BandAndRole> getBandAndRoleById(Long id) {
        return bandAndRoleRepository.findById(id);
    }

    public List<BandAndRole> getBandAndRolesByEmployeeId(String employeeId) {
        return bandAndRoleRepository.findByEmployeeId(employeeId);
    }

//    public BandAndRole updateBandAndRole(Long id, BandAndRole bandAndRoleDetails) {
//        BandAndRole bandAndRole = bandAndRoleRepository.findById(id).orElseThrow(() -> new RuntimeException("BandAndRole not found for id: " + id));
//        bandAndRole.setBandName(bandAndRoleDetails.getBandName());
//        bandAndRole.setRole(bandAndRoleDetails.getRole());
//        bandAndRole.setStartDate(bandAndRoleDetails.getStartDate());
//        bandAndRole.setEndDate(bandAndRoleDetails.getEndDate());
//        return bandAndRoleRepository.save(bandAndRole);
//    }

    public void deleteBandAndRole(Long id) {
        BandAndRole bandAndRole = bandAndRoleRepository.findById(id).orElseThrow(() -> new RuntimeException("BandAndRole not found for id: " + id));
        bandAndRoleRepository.delete(bandAndRole);
    }
}
