package com.employee.management.employee.repository;

import com.employee.management.employee.model.Employee;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;


public interface EmployeeRepository extends JpaRepository<Employee, Long> {



        // Custom query method to find employees by region ID
        @Query("SELECT e FROM Employee e WHERE e.region.id = :regionId")
        List<Employee> findByRegionId(@Param("regionId") Long regionId);


        //Custom query method for searching
        @Query("SELECT e FROM Employee e " +
                "WHERE (:firstName IS NULL OR LOWER(e.firstName) LIKE LOWER(CONCAT('%', :firstName, '%'))) AND " +
                "(:lastName IS NULL OR LOWER(e.lastName) LIKE LOWER(CONCAT('%', :lastName, '%'))) AND " +
                "(:joiningDate IS NULL OR e.joiningDate = :joiningDate) AND " +
                "(:dob IS NULL OR e.dob = :dob) AND " +
                "(:email IS NULL OR e.email = :email) " )
        List<Employee> findEmployeesByAttributes(@Param("firstName") String firstName,
                                                 @Param("lastName") String lastName,
                                                 @Param("joiningDate") Date joiningDate,
                                                 @Param("dob") Date dob,
                                                 @Param("email") String email,
                                                 @Param("projectName") String projectName);



        // New method to check existence of ID
        boolean existsById(String id);
}







