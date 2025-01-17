package com.employee.management.salary.service;

import com.employee.management.employee.model.Employee;
import com.employee.management.salary.exception.GenericServiceException;
import com.employee.management.salary.exception.SalaryNotFoundException;
import com.employee.management.salary.model.Salary;
import com.employee.management.salary.repository.SalaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SalaryService {

    @Autowired
     SalaryRepository salaryRepository;

    // Get all salaries
    public List<Salary> getAllSalaries() {
        return salaryRepository.findAll();
    }

    // Get salary by ID
    public Optional<Salary> getSalaryById(Long salaryId) {
        return salaryRepository.findById(salaryId);
    }

    // Create a new salary
    public Salary createSalary(Salary salary) {
        return salaryRepository.save(salary);
    }

    // Update salary
    public Salary updateSalary(Long salaryId, Salary salaryDetails) {
        Salary existingSalary = salaryRepository.findById(salaryId)
                .orElseThrow(() -> new RuntimeException("Salary not found"));

        existingSalary.setAmount(salaryDetails.getAmount());
        existingSalary.setCurrency(salaryDetails.getCurrency());
        existingSalary.setRole(salaryDetails.getRole());
        existingSalary.setSalaryStartDate(salaryDetails.getSalaryStartDate());
        existingSalary.setSalaryEndDate(salaryDetails.getSalaryEndDate());
        existingSalary.setBonus(salaryDetails.getBonus());
        existingSalary.setSalaryType(salaryDetails.getSalaryType());

        return salaryRepository.save(existingSalary);
    }

    // Delete salary by ID
    public void deleteSalary(Long salaryId) {
        salaryRepository.deleteById(salaryId);
    }


    // Method to get the highest-paid employee
//    public Optional<Double> getHighestUniqueSalary() {
//        Double highestSalary = salaryRepository.findHighestUniqueSalary();
//        return Optional.ofNullable(highestSalary);
//    }

    // Method to get the highest-paid employee
    public Optional<Double> getHighestUniqueSalary() {
        try {
            // Fetch the highest salary using a custom query or logic
            Double highestSalary = salaryRepository.findHighestUniqueSalary();

            if (highestSalary == null) {
                throw new SalaryNotFoundException("No records found for the highest salary.");
            }

            return Optional.of(highestSalary);
        } catch (Exception e) {
            throw new GenericServiceException("An error occurred while fetching the highest salary.");
        }
    }




//    public Employee getHighestPaidEmployeeByRegion(Long regionId) {
//        // Get the highest paid salary for the given region
//        Salary highestPaidSalary = salaryRepository.findHighestPaidSalaryByRegion(regionId);
//
//        // If no salary is found for the region, return null
//        if (highestPaidSalary != null) {
//            return highestPaidSalary.getEmployee(); // Return the employee associated with the highest salary
//        }
//
//        // Return null if no salary found for the region
//        return null;
//    }

    public Optional<Salary> getHighestPaidSalaryByRegion(Long regionId) {
        List<Salary> highestSalaryData = salaryRepository.findHighestPaidSalaryByRegion(regionId);
        if (!highestSalaryData.isEmpty()) {
            return Optional.of(highestSalaryData.get(0)); // Get the highest salary (first record)
        }
        return Optional.empty();
    }


    // Method to get the third-highest paid employee
    public Optional<Double> getThirdHighestUniqueSalary() {
        Double thirdHighestSalary = salaryRepository.findThirdHighestUniqueSalary();
        return Optional.ofNullable(thirdHighestSalary);
    }


    // Method to get the second-highest unique paid employee

    public Optional<Double> getSecondHighestUniqueSalary() {
        Double secondHighestSalary = salaryRepository.findSecondHighestUniqueSalary();
        return Optional.ofNullable(secondHighestSalary);
    }


    public Optional<Double> getLowestUniqueSalary(){
        Double lowestSalary= salaryRepository.findLowestUniqueSalary();
        return Optional.ofNullable(lowestSalary);
    }
}
