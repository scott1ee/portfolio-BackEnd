package com.portfolioweb.portfolio.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolioweb.portfolio.Model.Skills;
import com.portfolioweb.portfolio.Repository.SkillsRepository;

@Service
public class SkillsService implements ISkillsService {

     @Autowired
     private SkillsRepository skillsRepository;

     @Override
     public List<Skills> getAllSkills() {
          List<Skills> skills = skillsRepository.findAll();
          return skills;
     }

     @Override
     public void saveSkills(Skills skills) {
          skillsRepository.save(skills);
     }

     @Override
     public Skills findSkills(Long id) {
          Skills skills = skillsRepository.findById(id).orElse(null);
          return skills;
     }

     @Override
     public void deleteSkills(Long id) {
          skillsRepository.deleteById(id);
     }
}
