package com.portfolioweb.portfolio.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portfolioweb.portfolio.Model.Banner;

@Repository
public interface BannerRepository extends JpaRepository<Banner, Long>{
     
}
