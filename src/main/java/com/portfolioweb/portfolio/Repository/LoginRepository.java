package com.portfolioweb.portfolio.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portfolioweb.portfolio.Model.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login, Long> {


}
