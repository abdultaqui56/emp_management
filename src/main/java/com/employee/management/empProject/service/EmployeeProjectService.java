package com.employee.management.empProject.service;

import com.employee.management.empProject.model.EmployeeProject;
import com.employee.management.empProject.repository.EmployeeProjectRepository;
import com.employee.management.project.model.Project;
import com.employee.management.project.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeProjectService {

    @Autowired
    private EmployeeProjectRepository employeeProjectRepository;

    @Autowired
    private ProjectRepository projectRepository;

    public EmployeeProject createEmployeeProject(EmployeeProject employeeProject) {
        Project project = projectRepository.findById(employeeProject.getProject().getId())
                .orElseThrow(() -> new RuntimeException("Project not found with id "));

        employeeProject.setProject(project);
        employeeProjectRepository.save(employeeProject);
        return employeeProject;
    }

    public EmployeeProject getEmployeeProjectById(Long id) {
        Optional<EmployeeProject> employeeProject = employeeProjectRepository.findById(id);
        if (employeeProject.isPresent()) {
            return employeeProject.get();
        } else {
            throw new RuntimeException("EmployeeProject not found with id " + id);
        }
    }

    public List<EmployeeProject> getAllEmployeeProjects() {
        return employeeProjectRepository.findAll();
    }

//    public EmployeeProject updateEmployeeProject(Long id, EmployeeProject updatedEmployeeProject) {
//        Optional<EmployeeProject> existingEmployeeProject = employeeProjectRepository.findById(id);
//        if (existingEmployeeProject.isPresent()) {
//            EmployeeProject employeeProject = existingEmployeeProject.get();
//            employeeProject.setProject(updatedEmployeeProject.getProject());
//            employeeProject.setStartDate(updatedEmployeeProject.getStartDate());
//            employeeProject.setEndDate(updatedEmployeeProject.getEndDate());
//            return employeeProjectRepository.save(employeeProject);
//        } else {
//            throw new RuntimeException("EmployeeProject not found with id " + id);
//        }
//    }

    public void deleteEmployeeProject(Long id) {
        employeeProjectRepository.deleteById(id);
    }
}
