package com.portfolioweb.portfolio.Security;

import com.portfolioweb.portfolio.Model.Login;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;

import java.util.Collection;
import java.util.Collections;

@AllArgsConstructor
public class UserDetailsImpl implements UserDetails {

     private final Login user;

     @Override
     public Collection<? extends GrantedAuthority> getAuthorities() {
          return Collections.emptyList();
     }

     @Override
     public String getPassword() {
          return user.getPassword();
     }

     @Override
     public String getUsername() {
          return user.getUser();
     }

     @Override
     public boolean isAccountNonExpired() {
          return true;
     }

     @Override
     public boolean isAccountNonLocked() {
          return true;
     }

     @Override
     public boolean isCredentialsNonExpired() {
          return true;
     }

     @Override
     public boolean isEnabled() {
          return true;
     }

     public String getNombre() {
          return user.getUser();
     }
}
