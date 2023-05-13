package com.portfolioweb.portfolio.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolioweb.portfolio.Model.Projects;
import com.portfolioweb.portfolio.Repository.ProjectsRepository;

@Service
public class ProjectsService implements IProjectsService {

     @Autowired
     private ProjectsRepository projectsRepository;

     @Override
     public List<Projects> getAllProjects() {
          List<Projects> projects = projectsRepository.findAll();
          return projects;
     }

     @Override
     public void saveProjects(Projects projects) {
          projectsRepository.save(projects);
     }

     @Override
     public Projects findProjects(Long id) {
          Projects projects = projectsRepository.findById(id).orElse(null);
          return projects;
     }

     @Override
     public void deleteProjects(Long id) {
          projectsRepository.deleteById(id);
     }

}
