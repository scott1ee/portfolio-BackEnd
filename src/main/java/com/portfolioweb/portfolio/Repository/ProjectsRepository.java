package com.portfolioweb.portfolio.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portfolioweb.portfolio.Model.Projects;

@Repository
public interface ProjectsRepository extends JpaRepository<Projects, Long> {

}
