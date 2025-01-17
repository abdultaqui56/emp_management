package com.employee.management.organization.repository;

import com.employee.management.organization.model.Organization;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrganizationRepository extends JpaRepository<Organization, Long> {
}

