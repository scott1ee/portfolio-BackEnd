package com.portfolioweb.portfolio.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Login {

     @Id
     @GeneratedValue(strategy = GenerationType.SEQUENCE)
     private Long id;
     private String user;
     private String password;

}
