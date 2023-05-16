package com.portfolioweb.portfolio.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.portfolioweb.portfolio.Model.Login;
import com.portfolioweb.portfolio.Repository.LoginRepository;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
     
     @Autowired
     private LoginRepository loginRepository;

     @Override
     public UserDetails loadUserByUsername(String user) throws UsernameNotFoundException {
          Login userL = loginRepository
               .findOneByEmail(user)
               .orElseThrow(() -> new UsernameNotFoundException("El usuario con user " + user + " no existe"));

          return new UserDetailsImpl(userL);
     }

}
