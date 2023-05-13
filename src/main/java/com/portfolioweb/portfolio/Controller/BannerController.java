package com.portfolioweb.portfolio.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.portfolioweb.portfolio.Model.Banner;
import com.portfolioweb.portfolio.Service.IBannerService;

@RestController
public class BannerController {

     @Autowired
     private IBannerService interBanner;

     // Get
     @GetMapping("/banner/traer")
     public List<Banner> getAllBanners() {
          return interBanner.getAllBanners();
     }

     // Post
     @PostMapping("/banner/crear")
     public String createBanner(@RequestBody Banner banner) {
          interBanner.saveBanner(banner);
          return "Se CREO informacion a 'banner' correctamente!";
     }

     // Put
     @PutMapping("/banner/editar/{id}")
     public Banner editBanner(@PathVariable Long id,
               @RequestParam("description") String newDescription,
               @RequestParam("image_url") String newImage_url) {
          Banner banner = interBanner.findBanner(id);

          banner.setDescription(newDescription);
          banner.setImageUrl(newImage_url);

          interBanner.saveBanner(banner);
          return banner;
     }

     // Delete
     @DeleteMapping("/banner/borrar/{id}")
     public String deleteBanner(@PathVariable Long id) {
          interBanner.deleteBanner(id);
          return "Se ELIMINO informacion a 'banner' correctamente!";
     }

}