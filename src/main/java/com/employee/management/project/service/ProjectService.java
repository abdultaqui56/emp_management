package com.employee.management.project.service;

import com.employee.management.project.model.Project;
import com.employee.management.project.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

    @Autowired
    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public Project createProject(Project project) {
        return projectRepository.save(project);
    }

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    public Project getProjectById(Long id) {
        return projectRepository.findById(id).orElseThrow(() -> new RuntimeException("Project not found"));
    }

//    public Project updateProject(Long id, Project updatedProject) {
//        return projectRepository.findById(id).map(project -> {
//            project.setName(updatedProject.getName());
//            project.setDescription(updatedProject.getDescription());
//            project.setStartDate(updatedProject.getStartDate());
//            project.setEndDate(updatedProject.getEndDate());
//            return projectRepository.save(project);
//        }).orElseThrow(() -> new RuntimeException("Project not found"));
//    }

    public void deleteProject(Long id) {
        projectRepository.deleteById(id);
    }
}
