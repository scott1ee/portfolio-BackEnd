package com.portfolioweb.portfolio.Service;

import java.util.List;
import com.portfolioweb.portfolio.Model.Skills;

public interface ISkillsService {

     public List<Skills> getAllSkills();

     public void saveSkills(Skills skills);

     public Skills findSkills(Long id);

     public void deleteSkills(Long id);

}
