package com.employee.management.bandAndRole.Repository;

import com.employee.management.bandAndRole.model.BandAndRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BandAndRoleRepository extends JpaRepository<BandAndRole, Long> {
    List<BandAndRole> findByEmployeeId(String employeeId);
}
