package com.employee.management.employee.service;

import com.employee.management.employee.dto.SearchCriteriaDTO;
import com.employee.management.employee.exception.EmployeesNotFoundException;
import com.employee.management.employee.model.Employee;
import com.employee.management.employee.repository.EmployeeRepository;
import com.employee.management.empDetails.repository.EmpDetailsRepository;  // Import repository for EmpDetails
//import com.employee.management.employee.specification.EmployeeSpecification;
//import com.employee.management.employee.specification.EmployeeSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
public class EmployeeService {

    @Autowired
    private final EmployeeRepository employeeRepository;

    @Autowired
    private final EmpDetailsRepository empDetailsRepository;  // Inject EmpDetails repository


    public EmployeeService(EmployeeRepository employeeRepository, EmpDetailsRepository empDetailsRepository) {
        this.employeeRepository = employeeRepository;
        this.empDetailsRepository = empDetailsRepository;
    }

//    @Transactional  // Ensure atomic operation (Employee and EmpDetails saved in one transaction)
//    public Employee createEmployee(Employee employee) {
//        // Save the employee and get the generated ID
//        Employee savedEmployee = employeeRepository.save(employee);
//
//        // If empDetails exists, set the employee_id and save empDetails
//        if (savedEmployee.getEmpDetails() != null) {
//            savedEmployee.getEmpDetails().setEmployee(savedEmployee);  // Link empDetails to Employee
//            empDetailsRepository.save(savedEmployee.getEmpDetails());   // Save updated empDetails
//        }
//
//        // Return the saved employee object (with updated empDetails)
//        return savedEmployee;
//    }

    @Transactional
    public Employee createEmployee(Employee employee) {
        String uniqueId;
        do {
            uniqueId = generateRandomId();
        } while (employeeRepository.existsById(uniqueId)); // Ensure ID is unique

        employee.setId(uniqueId); // Ensure employee ID is set
        Employee savedEmployee = employeeRepository.save(employee);

        if (savedEmployee.getEmpDetails() != null) {
            savedEmployee.getEmpDetails().setEmployee(savedEmployee);
            empDetailsRepository.save(savedEmployee.getEmpDetails());
        }

        return savedEmployee;
    }
//    public List<Employee> getEmployeesByRegion(Long regionId) {
//        return employeeRepository.findByRegionId(regionId);
//    }

    // Get employees by region
    public List<Employee> getEmployeesByRegion(Long regionId) {
        List<Employee> employees = employeeRepository.findByRegionId(regionId);

        // If no employees are found, throw the custom exception
        if (employees.isEmpty()) {
            throw new EmployeesNotFoundException("No employees found for region ID: " + regionId);
        }

        return employees;
    }

    public List<Employee> filterEmployees(SearchCriteriaDTO criteria) {
        return employeeRepository.findEmployeesByAttributes(
                criteria.getFirstName(),
                criteria.getLastName(),
                criteria.getJoiningDate(),
                criteria.getDob(),
                criteria.getEmail(),
                criteria.getProjectName()
        );
    }


    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    private String generateRandomId() {
        Random random = new Random();
        int randomId = 100000 + random.nextInt(900000);
        return String.valueOf(randomId);
    }

}
