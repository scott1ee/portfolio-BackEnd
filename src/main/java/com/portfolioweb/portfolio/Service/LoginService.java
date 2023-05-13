package com.portfolioweb.portfolio.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolioweb.portfolio.Model.Login;
import com.portfolioweb.portfolio.Repository.LoginRepository;

@Service
public class LoginService implements ILoginService {

     @Autowired
     private LoginRepository loginRepository;

     @Override
     public List<Login> getLogin() {
          List<Login> login = loginRepository.findAll();
          return login;
     }

     @Override
     public void saveLogin(Login login) {
          loginRepository.save(login);
     }

     @Override
     public Login findLogin(Long id) {
          Login login = loginRepository.findById(id).orElse(null);
          return login;
     }

     @Override
     public void deleteLogin(Long id) {
          loginRepository.deleteById(id);
     }

}
