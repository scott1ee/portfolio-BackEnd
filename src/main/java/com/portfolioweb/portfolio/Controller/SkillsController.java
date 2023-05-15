package com.portfolioweb.portfolio.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.portfolioweb.portfolio.Model.Skills;
import com.portfolioweb.portfolio.Service.ISkillsService;

@RestController
public class SkillsController {

     @Autowired
     private ISkillsService interSkills;

     // Get
     @GetMapping("/skills/traer")
     public List<Skills> getAllSkillss() {
          return interSkills.getAllSkills();
     }

     // Post
     @PostMapping("/skills/crear")
     public String createSkills(@RequestBody Skills Skills) {
          interSkills.saveSkills(Skills);
          return "Se CREO informacion a 'Skills' correctamente!";
     }

     // Put
     @PutMapping("/skills/editar/{id}")
     public Skills editSkills(@PathVariable Long id,
               @RequestParam("title_language") String newTitle_language) {
          Skills skills = interSkills.findSkills(id);

          skills.setTitle_language(newTitle_language);

          interSkills.saveSkills(skills);
          return skills;
     }

     // Delete
     @DeleteMapping("/skills/borrar/{id}")
     public String deleteSkills(@PathVariable Long id) {
          interSkills.deleteSkills(id);
          return "Se ELIMINO informacion a 'Skills' correctamente!";
     }

}