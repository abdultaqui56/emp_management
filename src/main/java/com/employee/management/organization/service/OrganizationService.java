package com.employee.management.organization.service;

import com.employee.management.organization.model.Organization;
import com.employee.management.organization.repository.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrganizationService {

    @Autowired
    private OrganizationRepository organizationRepository;

    public Organization createOrganization(Organization organization) {
        return organizationRepository.save(organization);
    }

    public List<Organization> getAllOrganizations() {
        return organizationRepository.findAll();
    }

    public Optional<Organization> getOrganizationById(Long id) {
        return organizationRepository.findById(id);
    }

//    public Organization updateOrganization(Long id, Organization updatedOrganization) {
//        return organizationRepository.findById(id).map(org -> {
//            org.setOrgName(updatedOrganization.getOrgName());
//            org.setOrgAddress(updatedOrganization.getOrgAddress());
//            org.setWebsite(updatedOrganization.getWebsite());
//            return organizationRepository.save(org);
//        }).orElseThrow(() -> new RuntimeException("Organization not found with id " + id));
//    }

    public void deleteOrganization(Long id) {
        organizationRepository.deleteById(id);
    }
}

