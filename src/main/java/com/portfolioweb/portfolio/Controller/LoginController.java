package com.portfolioweb.portfolio.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.portfolioweb.portfolio.Model.Login;
import com.portfolioweb.portfolio.Service.ILoginService;

@RestController
public class LoginController {

     @Autowired
     private ILoginService interLogin;

     // Get
     @GetMapping("/login/traer")
     public List<Login> getLogin() {
          return interLogin.getLogin();
     }

     // Post
     @PostMapping("/login/crear")
     public String createLogin(@RequestBody Login Login) {
          interLogin.saveLogin(Login);
          return "Se CREO el 'usuario' y 'contraseña'!";
     }

     // Put
     @PutMapping("/login/editar/{id}")
     public Login editLogin(@PathVariable Long id,
               @RequestParam("user") String newUser,
               @RequestParam("password") String newPassword) {
          Login Login = interLogin.findLogin(id);

          Login.setUser(newUser);
          Login.setPassword(newPassword);

          interLogin.saveLogin(Login);
          return Login;
     }

     // Delete
     @DeleteMapping("/login/borrar/{id}")
     public String deleteLogin(@PathVariable Long id) {
          interLogin.deleteLogin(id);
          return "Se ELIMINO el 'usuario' y 'contraseña'!";
     }

}