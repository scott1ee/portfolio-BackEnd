package com.portfolioweb.portfolio.Service;

import java.util.List;
import com.portfolioweb.portfolio.Model.Education;

public interface IEducationService {

     public List<Education> getAllEducations();

     public void saveEducation(Education Education);

     public Education findEducation(Long id);

     public void deleteEducation(Long id);

}
