package com.employee.management.region.repository;

import com.employee.management.region.model.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@ Repository
public interface RegionRepository extends JpaRepository<Region, Long> {
}

