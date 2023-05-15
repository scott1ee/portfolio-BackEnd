package com.portfolioweb.portfolio.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portfolioweb.portfolio.Model.Skills;

@Repository
public interface SkillsRepository extends JpaRepository<Skills, Long> {

}
