package com.employee.management.empProject.repository;

import com.employee.management.empProject.model.EmployeeProject;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployeeProjectRepository extends JpaRepository<EmployeeProject, Long> {
    // Custom query methods can be added here if needed
}
