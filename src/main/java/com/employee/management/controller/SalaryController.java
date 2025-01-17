package com.employee.management.controller;

import com.employee.management.employee.model.Employee;
import com.employee.management.salary.exception.SalaryNotFoundException;
import com.employee.management.salary.model.Salary;
import com.employee.management.salary.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/salaries")
public class SalaryController {

    @Autowired
    private SalaryService salaryService;

    // Get all salaries
    @GetMapping
    public List<Salary> getAllSalaries() {
        return salaryService.getAllSalaries();
    }

    // Get salary by ID
    @GetMapping("/{id}")
    public ResponseEntity<Salary> getSalaryById(@PathVariable Long id) {
        Optional<Salary> salary = salaryService.getSalaryById(id);
        return salary.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Create a new salary
    @PostMapping
    public ResponseEntity<Salary> createSalary(@RequestBody Salary salary) {
        Salary createdSalary = salaryService.createSalary(salary);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdSalary);
    }

    // Update salary by ID
    @PutMapping("/{id}")
    public ResponseEntity<Salary> updateSalary(@PathVariable Long id, @RequestBody Salary salary) {
        Salary updatedSalary = salaryService.updateSalary(id, salary);
        return ResponseEntity.ok(updatedSalary);
    }

    // Delete salary by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSalary(@PathVariable Long id) {
        salaryService.deleteSalary(id);
        return ResponseEntity.noContent().build();
    }

    // Get the highest-paid employee irrespective of region
//    @GetMapping("/highest-paid")
//    public ResponseEntity<String> getHighestPaidEmployee() {
//        Optional<Double> highestSalary = salaryService.getHighestUniqueSalary();
//        if (highestSalary.isPresent()) {
//            return ResponseEntity.ok("Highest salary: " + highestSalary.get());
//        } else {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No records found for the highest salary.");
//        }
//    }

    @GetMapping("/highest-paid")
    public ResponseEntity<String> getHighestPaidEmployee() {
        Optional<Double> highestSalary = salaryService.getHighestUniqueSalary();

        return highestSalary
                .map(salary -> ResponseEntity.ok("Highest salary: " + salary))
                .orElseThrow(() -> new SalaryNotFoundException("No records found for the highest salary."));
    }


    // Get the highest-paid employee based on region
//    @GetMapping("/highest-paid/region/{regionId}")
//    public ResponseEntity<?> getHighestPaidEmployeeByRegion(@PathVariable Long regionId) {
//        try {
//            Employee highestPaidEmployee = salaryService.getHighestPaidEmployeeByRegion(regionId);
//            if (highestPaidEmployee != null) {
//                return ResponseEntity.ok(highestPaidEmployee);
//            } else {
//                return ResponseEntity.status(HttpStatus.NOT_FOUND)
//                        .body("No employees found in this region");
//            }
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                    .body("An error occurred while fetching the highest-paid employee");
//        }
//    }



    @GetMapping("/highest-paid/region/{regionId}")
    public ResponseEntity<String> getHighestPaidSalaryByRegion(@PathVariable Long regionId) {
        Optional<Salary> highestPaidSalary = salaryService.getHighestPaidSalaryByRegion(regionId);

        if (highestPaidSalary.isPresent()) {
            Salary salary = highestPaidSalary.get();
            Double highestSalary = salary.getAmount();  // Get the highest salary amount
            Long regionIdFromData = salary.getEmployee().getRegion().getId();  // Get the region ID from the employee

            // Return the region and highest salary
            return ResponseEntity.ok("Region ID: " + regionIdFromData + " - Highest Salary: " + highestSalary);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No records found for region " + regionId);
        }
    }







    // Endpoint to get the third-highest paid employee
    @GetMapping("/third-highest-paid")
    public ResponseEntity<String> getThirdHighestPaidEmployee() {
        Optional<Double> thirdHighestSalary = salaryService.getThirdHighestUniqueSalary();
        if (thirdHighestSalary.isPresent()) {
            return ResponseEntity.ok("Third highest salary: " + thirdHighestSalary.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No records found for the third highest salary.");
        }
    }


    // second highest salary
    @GetMapping("/second-highest-paid")
    public ResponseEntity<String> getSecondHighestPaidEmployee() {
        Optional<Double> secondHighestSalary = salaryService.getSecondHighestUniqueSalary();
        if (secondHighestSalary.isPresent()) {
            return ResponseEntity.ok("Second highest salary: " + secondHighestSalary.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No records found for the second highest salary.");
        }
    }

    //lowest paid salary
    @GetMapping("/lowest-paid")
    public ResponseEntity<String> getLowestPaidSalary() {
        Optional<Double> lowestSalary = salaryService.getLowestUniqueSalary();
        if (lowestSalary.isPresent()) {
            return ResponseEntity.ok("Lowest salary: " + lowestSalary.get());
        } else {
            return ResponseEntity.status(404).body("No salary records found.");
        }
    }

 }
