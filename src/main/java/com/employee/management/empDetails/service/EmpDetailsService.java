package com.employee.management.empDetails.service;

import com.employee.management.empDetails.model.EmpDetails;
import com.employee.management.empDetails.repository.EmpDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpDetailsService {

    @Autowired
    private final EmpDetailsRepository empDetailsRepository;

    public EmpDetailsService(EmpDetailsRepository empDetailsRepository) {
        this.empDetailsRepository = empDetailsRepository;
    }

    public EmpDetails createEmpDetails(EmpDetails empDetails) {
        return empDetailsRepository.save(empDetails);
    }

    public EmpDetails getEmpDetailsById(Long id) {
        return empDetailsRepository.findById(id).orElse(null);
    }

//    public EmpDetails updateEmpDetails(Long id, EmpDetails updatedDetails) {
//        return empDetailsRepository.findById(id).map(details -> {
//            details.setCity(updatedDetails.getCity());
//            details.setAddress(updatedDetails.getAddress());
//            details.setPhoneNumber(updatedDetails.getPhoneNumber());
//            details.setGender(updatedDetails.getGender());
//            return empDetailsRepository.save(details);
//        }).orElseThrow(() -> new RuntimeException("EmpDetails not found with id " + id));
//    }

    public void deleteEmpDetails(Long id) {
        empDetailsRepository.deleteById(id);
    }
}
