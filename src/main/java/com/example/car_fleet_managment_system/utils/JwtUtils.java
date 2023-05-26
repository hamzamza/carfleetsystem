package com.example.car_fleet_managment_system.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtils {
    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expirationMs}")
    private int expirationMs;

    public String generateToken(Long userId, String username , Boolean isAdmin ) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + expirationMs);

        return Jwts.builder()
                .setSubject(Long.toString(userId))
                .claim("username", username)
                .claim("isAdmin", isAdmin)
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();

    }
    public Pyload parseToken(String token) {
        try {
            Jws<Claims> jws = Jwts.parserBuilder()
                    .setSigningKey(secret)
                    .build()
                    .parseClaimsJws(token);

            Claims claims = jws.getBody();

            long id = Long.parseLong(claims.getSubject());
            String username = (String) claims.get("username");
            boolean isAdmin = (boolean) claims.get("isAdmin");

            return new Pyload(id, username, isAdmin);
        } catch (io.jsonwebtoken.JwtException e) {
            // Handle JWT parsing exception
            // You can log the error or perform any other necessary actions
            e.printStackTrace();
            return null;
        }
    }

}
