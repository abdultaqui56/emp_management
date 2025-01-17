package com.employee.management.controller;

import com.employee.management.empProject.model.EmployeeProject;
import com.employee.management.empProject.service.EmployeeProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee-projects")
public class EmployeeProjectController {

    @Autowired
    private EmployeeProjectService employeeProjectService;

    @PostMapping
    public EmployeeProject createEmployeeProject(@RequestBody EmployeeProject employeeProject) {
        return employeeProjectService.createEmployeeProject(employeeProject);
    }

    @GetMapping("/{id}")
    public EmployeeProject getEmployeeProjectById(@PathVariable Long id) {
        return employeeProjectService.getEmployeeProjectById(id);
    }

    @GetMapping
    public List<EmployeeProject> getAllEmployeeProjects() {
        return employeeProjectService.getAllEmployeeProjects();
    }

//    @PutMapping("/{id}")
//    public EmployeeProject updateEmployeeProject(@PathVariable Long id, @RequestBody EmployeeProject employeeProject) {
//        return employeeProjectService.updateEmployeeProject(id, employeeProject);
//    }

    @DeleteMapping("/{id}")
    public void deleteEmployeeProject(@PathVariable Long id) {
        employeeProjectService.deleteEmployeeProject(id);
    }
}
