package firstproject.demo.security;

import firstproject.demo.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

@Component
public class JwtGenerator {

    public String generate(User user) {
        Claims claims = Jwts.claims()
                .setSubject(user.getUsername());
        claims.setSubject(user.getPassword());
        claims.setSubject(user.getFullName());
        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, "youtube")
                .compact();
    }
}
