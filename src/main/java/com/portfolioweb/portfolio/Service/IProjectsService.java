package com.portfolioweb.portfolio.Service;

import java.util.List;
import com.portfolioweb.portfolio.Model.Projects;

public interface IProjectsService {
     
     public List<Projects> getAllProjects();

     public void saveProjects(Projects projects);

     public Projects findProjects(Long id);

     public void deleteProjects(Long id);

}
