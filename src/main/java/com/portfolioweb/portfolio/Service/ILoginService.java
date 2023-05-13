package com.portfolioweb.portfolio.Service;

import java.util.List;
import com.portfolioweb.portfolio.Model.Login;

public interface ILoginService {
     
     public List<Login> getLogin();

     public void saveLogin(Login login);

     public Login findLogin(Long id);

     public void deleteLogin(Long id);

}
