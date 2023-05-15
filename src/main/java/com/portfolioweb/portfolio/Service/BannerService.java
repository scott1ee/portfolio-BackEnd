package com.portfolioweb.portfolio.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolioweb.portfolio.Model.Banner;
import com.portfolioweb.portfolio.Repository.BannerRepository;

@Service
public class BannerService implements IBannerService {

     @Autowired
     private BannerRepository bannerRepository;

     @Override
     public List<Banner> getAllBanners() {
          List<Banner> banners = bannerRepository.findAll();
          return banners;
     }

     @Override
     public void saveBanner(Banner banner) {
          bannerRepository.save(banner);
     }

     @Override
     public Banner findBanner(Long id) {
          Banner banner = bannerRepository.findById(id).orElse(null);
          return banner;
     }

     @Override
     public void deleteBanner(Long id) {
          bannerRepository.deleteById(id);
     }

}
