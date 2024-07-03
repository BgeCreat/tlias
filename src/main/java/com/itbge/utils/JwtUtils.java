package com.itbge.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import java.util.Date;

public class JwtUtils {

    private static final String SECRET_KEY = "your_secret_key";
    private static final long EXPIRATION_TIME = 86400000; // 1天

    public static String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                .compact();
    }

    public static Claims getClaimsFromToken(String token) throws SignatureException {
        try {
            return Jwts.parser()
                    .setSigningKey(SECRET_KEY)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (SignatureException e) {
            System.out.println("Invalid JWT signature: " + e.getMessage());
            throw e;
        }
    }

    public static boolean isTokenExpired(String token) {
        return getClaimsFromToken(token).getExpiration().before(new Date());
    }
}
