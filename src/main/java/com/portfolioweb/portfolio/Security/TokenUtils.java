package com.portfolioweb.portfolio.Security;

import java.sql.Date;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

public class TokenUtils {

     private final static String ACCESS_TOKEN_SECRET = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9";
     private final static Long ACCESS_TOKEN_VALIDITY_SECONDS = 2_592_000L;

     public static String createToken(String user) {
          long expirationTime = ACCESS_TOKEN_VALIDITY_SECONDS * 1000;
          Date expirationDate = new Date(System.currentTimeMillis() + expirationTime);

          Map<String, Object> extra = new HashMap<>();
          extra.put("user", user);

          return Jwts.builder()
               .setSubject(user)
               .setExpiration(expirationDate)
               .addClaims(extra)
               .signWith(Keys.hmacShaKeyFor(ACCESS_TOKEN_SECRET.getBytes()))
               .compact();
     }

     public static UsernamePasswordAuthenticationToken getAuthentication(String token) {
          try {
               Claims claims = Jwts.parserBuilder()
                    .setSigningKey(ACCESS_TOKEN_SECRET.getBytes())
                    .build()
                    .parseClaimsJws(token)
                    .getBody();

               String user = claims.getSubject();

               return new UsernamePasswordAuthenticationToken(user, null, Collections.emptyList());
          } catch (JwtException e) {
               return null;
          }
     }

}
