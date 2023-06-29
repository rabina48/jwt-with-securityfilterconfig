package com.example.springjwt.config;

import com.auth0.jwt.interfaces.Claim;
import com.example.springjwt.dtos.request.ClaimReqDto;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/**
 * @author : Rabina Shrestha
 * @Date : 27/06/2023
 * @email : rabina.shrestha@codehimalaya.tech
 */

@Service
public class JwtService {
    private static final String SECRET_KEY = "75EFA90F9ED0F10FA9577ED3F1A573C67726B08A75C5C6CE607C592436D9F46E\n";

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    private <T> T extractClaim(String token, Function<Claims, T> clamsResolver) {
        final Claims claims = extractAllClaims(token);

//        extractClaims(token);
        return clamsResolver.apply(claims);
    }

//    private Map<String, Object> extractClaims(String token) {
//        final Claims claims = extractAllClaims(token);
//       List<String> roles= (List<String>) claims.get("role");
//        claims.get("sub");
//
////        ClaimReqDto claimReqDto =
//
//        return claims;
//    }


//    public ClaimReqDto extractEachBody(String token){
//        Claims claims = extractAllClaims(token);
//        claims.get("token");
//        return null;
//    }

//    public String generateToken(UserDetails userDetails) {
//        return generateToken(new HashMap<>(), userDetails);
//    }


    //generate token + generate token via Role
    public String generateToken(
            String userDetails, List<String> roles, Integer id
    ) {
        return Jwts.builder()
                .setSubject(userDetails)
                .claim("role", roles)
                .claim("userId", id)
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24)) //24 jrs
                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    // to valid token
    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    public Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSignInKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private Key getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
