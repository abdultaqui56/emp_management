package com.employee.management.empDetails.repository;

import com.employee.management.empDetails.model.EmpDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpDetailsRepository extends JpaRepository<EmpDetails, Long> {
}

