package com.mood.Moodania.ServiceLayer.Services.Implementations;

import com.mood.Moodania.DataAccessLayer.Entities.AccountEntity;
import com.mood.Moodania.Presentation.Exceptions.JwtAuthenticationException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.UUID;
import java.util.function.Function;

@Service
public class JwtService {

    @Value("${jwt.token.secret}")
    private String jwtSecret;

    public String getEmail(String token) {
        return getClaim(token, Claims::getSubject);
    }

    public Claims getAllClaims(String token) {
        return Jwts
                .parserBuilder()
                .setSigningKey(getSecret())
                .build()
                .parseClaimsJwt(token)
                .getBody();
    }

    public String createToken(String email, UUID accountId, String role) {
        Claims claims = Jwts.claims();
        claims.put("accountId", accountId);
        claims.put("role", role);

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(email)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 10000 * 60 * 24))
                .signWith(getSecret(), SignatureAlgorithm.HS256)
                .compact();
    }

    public boolean isValidToken(String token, UserDetails details) throws JwtAuthenticationException {
        String email = getEmail(token);
        return IsTokenExpired(token) && (email.equals(details.getUsername()));
    }

    private boolean IsTokenExpired(String token) {
        return getClaim(token, Claims::getExpiration).before(new Date());
    }

    private Key getSecret() {
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));
    }

    private <T> T getClaim(String token, Function<Claims, T> claimsFunc) {
        var claims = getAllClaims(token);
        return claimsFunc.apply(claims);
    }
}
