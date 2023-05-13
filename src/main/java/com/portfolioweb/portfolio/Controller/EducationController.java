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
     public String createEducation(@RequestBody Education Education) {
          interEducation.saveEducation(Education);
          return "Se CREO informacion a 'education' correctamente!";
     }

     // Put
     @PutMapping("/education/editar/{id}")
     public Education editEducation(@PathVariable Long id,
               @RequestParam("description") String newDescription) {
          Education Education = interEducation.findEducation(id);

          Education.setDescription(newDescription);

          interEducation.saveEducation(Education);
          return Education;
     }

     // Delete
     @DeleteMapping("/education/borrar/{id}")
     public String deleteEducation(@PathVariable Long id) {
          interEducation.deleteEducation(id);
          return "Se ELIMINO informacion a 'education' correctamente!";
     }

}