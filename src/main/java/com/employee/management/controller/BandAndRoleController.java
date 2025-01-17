package com.employee.management.controller;

import com.employee.management.bandAndRole.model.BandAndRole;
import com.employee.management.bandAndRole.service.BandAndRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/band-and-roles")
public class BandAndRoleController {

    @Autowired
    private final BandAndRoleService bandAndRoleService;

    public BandAndRoleController(BandAndRoleService bandAndRoleService) {
        this.bandAndRoleService = bandAndRoleService;
    }

//    @PostMapping
//    public ResponseEntity<BandAndRole> createBandAndRole(@RequestBody BandAndRole bandAndRole) {
//        BandAndRole savedBandAndRole = bandAndRoleService.createBandAndRole(bandAndRole);
//        System.out.println("Saved BandAndRole: " + savedBandAndRole);  // Log the saved object
//        return ResponseEntity.ok(savedBandAndRole);
//    }

    @PostMapping
    public BandAndRole createBandAndRole(@RequestBody BandAndRole bandAndRole){
        return bandAndRoleService.createBandAndRole(bandAndRole);
    }

    @GetMapping
    public ResponseEntity<List<BandAndRole>> getAllBandAndRoles() {
        return ResponseEntity.ok(bandAndRoleService.getAllBandAndRoles());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BandAndRole> getBandAndRoleById(@PathVariable Long id) {
        return bandAndRoleService.getBandAndRoleById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<List<BandAndRole>> getBandAndRolesByEmployeeId(@PathVariable String employeeId) {
        return ResponseEntity.ok(bandAndRoleService.getBandAndRolesByEmployeeId(employeeId));
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<BandAndRole> updateBandAndRole(@PathVariable Long id, @RequestBody BandAndRole bandAndRoleDetails) {
//        return ResponseEntity.ok(bandAndRoleService.updateBandAndRole(id, bandAndRoleDetails));
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBandAndRole(@PathVariable Long id) {
        bandAndRoleService.deleteBandAndRole(id);
        return ResponseEntity.noContent().build();
    }
}
