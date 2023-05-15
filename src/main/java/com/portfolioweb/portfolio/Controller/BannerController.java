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
               @RequestParam("title_name") String newTitle_name,
               @RequestParam("title_ocupation") String newTitle_ocupation,
               @RequestParam("title_about") String newTitle_about,
               @RequestParam("description") String newDescription,
               @RequestParam("image_background") String newImage_background,
               @RequestParam("image_me") String newImage_me) {
          Banner banner = interBanner.findBanner(id);

          banner.setTitle_name(newTitle_name);
          banner.setTitle_ocupation(newTitle_ocupation);
          banner.setTitle_about(newTitle_about);
          banner.setDescription(newDescription);
          banner.setImage_background(newImage_background);
          banner.setImage_me(newImage_me);

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