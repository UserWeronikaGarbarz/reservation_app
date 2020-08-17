package com.reservation.security.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.reservation.constant.SecurityConstant;
import com.reservation.security.service.GuestAutentication;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

@Component
public class JWTTokenProvider {
    @Value("${jwt.secret}")
    private String secret;

    public String generateJWTToken(GuestAutentication guestAutentication) {
        String[] claims = getClaimsFromUser(guestAutentication);
        return JWT.create()
                .withIssuer(SecurityConstant.GET_ARRAYS_LCC)
                .withAudience(SecurityConstant.GET_ARRAYS_ADMINISTRATION)
                .withIssuedAt(new Date())
                .withSubject(guestAutentication.getUsername())
                .withArrayClaim(SecurityConstant.AUTHORITIES, claims)
                .sign(Algorithm.HMAC512(secret.getBytes()));
    }

    public List<GrantedAuthority> grantedAuthorities(String token) {
        String[] claims = getClaimsFromToken(token);
        return stream(claims).map(SimpleGrantedAuthority::new).collect(Collectors.toList());
    }

    public Authentication getAutentication(String username, List<GrantedAuthority> authorities,
                                           HttpServletRequest request) {
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(username, null, authorities);
        authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        return authenticationToken;
    }

    public boolean isTokenValid(String username, String token) {
        JWTVerifier verifier = getJWTVerifier();
        return StringUtils.isNotEmpty(username) && isTokenValid(username, token);
    }

    public String getSubject(String token) {
        JWTVerifier verifier = getJWTVerifier();
        return verifier.verify(token).getSubject();
    }

    private String[] getClaimsFromToken(String token) {
        JWTVerifier verifier = getJWTVerifier();
        return verifier.verify(token).getClaim(SecurityConstant.AUTHORITIES).asArray(String.class);
    }

    private JWTVerifier getJWTVerifier() {
        JWTVerifier verifier;
        try {
            Algorithm algorithm = Algorithm.HMAC512(secret);
            verifier = JWT.require(algorithm).withIssuer(SecurityConstant.GET_ARRAYS_LCC).build();
        } catch (JWTVerificationException e) {
            throw new JWTVerificationException(SecurityConstant.TOKEN_CANNOT_BE_VERIFIED);
        }
        return verifier;
    }

    private String[] getClaimsFromUser(GuestAutentication guest) {
        List<String> authorities = new ArrayList<>();
        for (GrantedAuthority grantedAuthority : guest.getAuthorities()) {
            authorities.add(grantedAuthority.getAuthority());
        }
        return authorities.toArray(new String[0]);
    }
}
