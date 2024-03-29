package com.portfolioweb.portfolio.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Banner {

     @Id
     @GeneratedValue(strategy = GenerationType.SEQUENCE)
     private Long id;
     private String title_name;
     private String title_ocupation;
     private String title_about;
     private String description;
     private String image_background;
     private String image_me;
     
}
