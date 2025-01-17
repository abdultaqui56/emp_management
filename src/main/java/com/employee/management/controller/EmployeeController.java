package com.employee.management.controller;

import com.employee.management.employee.dto.SearchCriteriaDTO;
import com.employee.management.employee.model.Employee;
import com.employee.management.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // Create an employee
    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        return ResponseEntity.ok(employeeService.createEmployee(employee));
    }

    // Get employees by region
    @GetMapping("/region/{regionId}")
    public ResponseEntity<List<Employee>> getEmployeesByRegion(@PathVariable Long regionId) {
        return ResponseEntity.ok(employeeService.getEmployeesByRegion(regionId));
    }

    // Get all employees
    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @PostMapping("/filter")
    public ResponseEntity<List<Employee>> filterEmployees(@RequestBody SearchCriteriaDTO criteria) {
        List<Employee> employees = employeeService.filterEmployees(criteria);
        return ResponseEntity.ok(employees);
    }



}

