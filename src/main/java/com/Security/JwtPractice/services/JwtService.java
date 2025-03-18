package com.Security.JwtPractice.services;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.sql.Date;
import java.time.Instant;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

@Service
public class JwtService {

    @Value("${jwt.secret}")
    private  String SECRET;
    private static final long VALIDITY = TimeUnit.MINUTES.toMillis(30);



    public String generateToken(UserDetails userDetails) {
        return generateToken(new HashMap<>(), userDetails);
    }
    public String generateToken(
            Map<String, Object> claims,
            UserDetails userDetails
    )
    {
        System.out.println(getSigningKey());

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(Date.from(Instant.now()))
                .setExpiration(Date.from(Instant.now().plusMillis(VALIDITY)))
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public boolean isValidToken(String token, UserDetails userDetails) {
        return !isExpired(token) && extractUsername(token).equals(userDetails.getUsername());
    }

    public boolean isExpired(String token) {
          return extractExpiration(token).toInstant().isBefore(Instant.now());

    }

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public java.util.Date extractExpiration(String token)
    {
         return extractClaim(token, Claims::getExpiration);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimResolver){
        return claimResolver.apply(extractAllClaims(token));
    }

    public Claims extractAllClaims(String token) {

        return Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .setAllowedClockSkewSeconds(59)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public Key getSigningKey() {

        System.out.println("SECRET from properties: " + SECRET);

        byte[] decodedSec = Base64.getDecoder().decode(SECRET);
        return Keys.hmacShaKeyFor(decodedSec);

    }


}
