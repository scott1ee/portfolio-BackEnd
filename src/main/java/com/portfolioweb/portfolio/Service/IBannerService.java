package com.portfolioweb.portfolio.Service;

import java.util.List;
import com.portfolioweb.portfolio.Model.Banner;

public interface IBannerService {
     
     public List<Banner> getAllBanners();

     public void saveBanner(Banner banner);

     public Banner findBanner(Long id);

     public void deleteBanner(Long id);

}
