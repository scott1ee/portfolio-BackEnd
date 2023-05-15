package com.portfolioweb.portfolio.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.portfolioweb.portfolio.Model.Education;
import com.portfolioweb.portfolio.Service.IEducationService;

@RestController
public class EducationController {

     @Autowired
     private IEducationService interEducation;

     // Get
     @GetMapping("/education/traer")
     public List<Education> getAllEducations() {
          return interEducation.getAllEducations();
     }

     // Post
     @PostMapping("/education/crear")
     public String createEducation(@RequestBody Education education) {
          interEducation.saveEducation(education);
          return "Se CREO informacion a 'education' correctamente!";
     }

     // Put
     @PutMapping("/education/editar/{id}")
     public Education editEducation(@PathVariable Long id,
               @RequestParam("title") String newTitle,
               @RequestParam("title_grade") String newTitle_grade,
               @RequestParam("title_trayectory") String newTitle_trayectory,
               @RequestParam("description") String newDescription) {
          Education education = interEducation.findEducation(id);
          
          education.setTitle(newTitle);
          education.setTitle_grade(newTitle_grade);
          education.setTitle_trayectory(newTitle_trayectory);
          education.setDescription(newDescription);

          interEducation.saveEducation(education);
          return education;
     }

     // Delete
     @DeleteMapping("/education/borrar/{id}")
     public String deleteEducation(@PathVariable Long id) {
          interEducation.deleteEducation(id);
          return "Se ELIMINO informacion a 'education' correctamente!";
     }

}