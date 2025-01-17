package com.employee.management.controller;

import com.employee.management.empDetails.model.EmpDetails;
import com.employee.management.empDetails.service.EmpDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/empdetails")
public class EmpDetailsController {

    @Autowired
    private final EmpDetailsService empDetailsService;

    public EmpDetailsController(EmpDetailsService empDetailsService) {
        this.empDetailsService = empDetailsService;
    }

    // Create new EmpDetails
    @PostMapping
    public ResponseEntity<EmpDetails> createEmpDetails(@RequestBody EmpDetails empDetails) {
        return ResponseEntity.ok(empDetailsService.createEmpDetails(empDetails));
    }

    // Get EmpDetails by ID
    @GetMapping("/{id}")
    public ResponseEntity<EmpDetails> getEmpDetailsById(@PathVariable Long id) {
        return ResponseEntity.ok(empDetailsService.getEmpDetailsById(id));
    }

    // Update EmpDetails
//    @PutMapping("/{id}")
//    public ResponseEntity<EmpDetails> updateEmpDetails(@PathVariable Long id, @RequestBody EmpDetails empDetails) {
//        return ResponseEntity.ok(empDetailsService.updateEmpDetails(id, empDetails));
//    }

    // Delete EmpDetails
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmpDetails(@PathVariable Long id) {
        empDetailsService.deleteEmpDetails(id);
        return ResponseEntity.noContent().build();
    }
}

