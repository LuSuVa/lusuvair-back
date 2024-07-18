package fr.lusuva.lusuvair.services;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

/**
 * Service representing Jwt
 */
@Service
public class JwtService {
    /**
     * Jwt secret key
     */
    @Value("${token.signing.key}")
    private String jwtSigningKey;

    // /**
    // * Extract User Name
    // * @param token String
    // * @return String
    // */
    // public String extractUserName(String token) {
    // return extractClaim(token, Claims::getSubject);
    // }

    // /**
    // * Generate token
    // * @param userDetails UserDetails
    // * @return String token
    // */
    // public String generateToken(UserDetails userDetails) {
    // return generateToken(new HashMap<>(), userDetails);
    // }

    // /**
    // * Check if a token is valid
    // * @param token String
    // * @param userDetails UserDetails
    // * @return True if valid, false if not
    // */
    // public boolean isTokenValid(String token, UserDetails userDetails) {
    // final String userName = extractUserName(token);
    // return (userName.equals(userDetails.getUsername()));
    // }

    // /**
    // * Extract Claim
    // * @param <T>
    // * @param token String
    // * @param claimsResolvers
    // * @return T
    // */
    // private <T> T extractClaim(String token, Function<Claims, T> claimsResolvers)
    // {
    // final Claims claims = extractAllClaims(token);
    // return claimsResolvers.apply(claims);
    // }

    // /**
    // * Generate token
    // * @param extraClaims Map<String, Object>
    // * @param userDetails UserDetails
    // * @return String token
    // */
    // private String generateToken(Map<String, Object> extraClaims, UserDetails
    // userDetails) {
    // return
    // Jwts.builder().setClaims(extraClaims).setSubject(userDetails.getUsername())
    // .setIssuedAt(new Date(System.currentTimeMillis()))
    // .signWith(getSigningKey(), SignatureAlgorithm.HS256).compact();
    // }

    // /**
    // * Extract all claims
    // * @param token String
    // * @return Claims
    // */
    // private Claims extractAllClaims(String token) {
    // return
    // Jwts.parserBuilder().setSigningKey(getSigningKey()).build().parseClaimsJws(token)
    // .getBody();
    // }

    // /**
    // * Get signing key
    // * @return Key
    // */
    // private Key getSigningKey() {
    // byte[] keyBytes = Decoders.BASE64.decode(jwtSigningKey);
    // return Keys.hmacShaKeyFor(keyBytes);
    // }

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts
                .parserBuilder()
                .setSigningKey(getSignKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    // private Boolean isTokenExpired(String token) {
    //     return extractExpiration(token).before(new Date());
    // }

    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()));
        // return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    public String generateToken(String username) {
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, username);
    }

    private String createToken(Map<String, Object> claims, String username) {

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                // .setExpiration(new Date(System.currentTimeMillis()+1000*60*1))
                .signWith(getSignKey(), SignatureAlgorithm.HS256).compact();
    }

    private Key getSignKey() {
        byte[] keyBytes = Decoders.BASE64.decode(jwtSigningKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
