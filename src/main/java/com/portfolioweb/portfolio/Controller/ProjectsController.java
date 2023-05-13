package com.portfolioweb.portfolio.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.portfolioweb.portfolio.Model.Projects;
import com.portfolioweb.portfolio.Service.IProjectsService;

@RestController
public class ProjectsController {

     @Autowired
     private IProjectsService interProjects;

     // Get
     @GetMapping("/projects/traer")
     public List<Projects> getAllProjectss() {
          return interProjects.getAllProjects();
     }

     // Post
     @PostMapping("/projects/crear")
     public String createProjects(@RequestBody Projects projects) {
          interProjects.saveProjects(projects);
          return "Se CREO informacion a 'Projects' correctamente!";
     }

     // Put
     @PutMapping("/projects/editar/{id}")
     public Projects editProjects(@PathVariable Long id,
               @RequestParam("description") String newDescription,
               @RequestParam("image_url") String newImage_url) {

          Projects projects = interProjects.findProjects(id);

          projects.setDescription(newDescription);
          projects.setImageUrl(newImage_url);

          interProjects.saveProjects(projects);
          return projects;
     }

     // Delete
     @DeleteMapping("/projects/borrar/{id}")
     public String deleteProjects(@PathVariable Long id) {
          interProjects.deleteProjects(id);
          return "Se ELIMINO informacion a 'Projects' correctamente!";
     }

}