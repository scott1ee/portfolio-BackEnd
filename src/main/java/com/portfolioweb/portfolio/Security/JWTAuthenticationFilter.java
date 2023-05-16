package com.portfolioweb.portfolio.Security;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import io.jsonwebtoken.io.IOException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.Collections;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

     @Override
     public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
               throws AuthenticationException {

          AuthCredentials authCredentials = new AuthCredentials();

          try {
               authCredentials = new ObjectMapper().readValue(request.getReader(), AuthCredentials.class);
          } catch (IOException e) {
          } catch (StreamReadException e) {
               e.printStackTrace();
          } catch (DatabindException e) {
               e.printStackTrace();
          } catch (java.io.IOException e) {
               e.printStackTrace();
          }

          UsernamePasswordAuthenticationToken usernamePAT = new UsernamePasswordAuthenticationToken(
                    authCredentials.getEmail(),
                    authCredentials.getPassword(),
                    Collections.emptyList());

          return getAuthenticationManager().authenticate(usernamePAT);
     }

     @Override
     protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response,
               FilterChain chain, Authentication authResult) throws java.io.IOException, ServletException {

          UserDetailsImpl userDetails = (UserDetailsImpl) authResult.getPrincipal();
          String token = TokenUtils.createToken(userDetails.getUsername());
          
          response.addHeader("Authorization", "Bearer " + token);
          response.getWriter().flush();

          super.successfulAuthentication(request, response, chain, authResult);
     }

}
