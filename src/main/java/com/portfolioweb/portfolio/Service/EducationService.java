package com.portfolioweb.portfolio.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolioweb.portfolio.Model.Education;
import com.portfolioweb.portfolio.Repository.EducationRepository;

@Service
public class EducationService implements IEducationService {

     @Autowired
     private EducationRepository educationRepository;
     
     @Override
     public List<Education> getAllEducations() {
          List<Education> educations = educationRepository.findAll();
          return educations;
     }

     @Override
     public void saveEducation(Education education){
          educationRepository.save(education);
     }

     @Override
     public Education findEducation(Long id) {
          Education education = educationRepository.findById(id).orElse(null);
          return education;          
     }

     @Override
     public void deleteEducation(Long id){
          educationRepository.deleteById(id);
     }
     
}
