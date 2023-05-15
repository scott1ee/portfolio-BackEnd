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
public class Skills {
     @Id
     @GeneratedValue(strategy = GenerationType.SEQUENCE)
     private Long id;
     private String title_language;
}
