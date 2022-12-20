package com.avion.avion.Gestiontoken;

import java.util.Date;
import javax.servlet.http.HttpServletRequest;

import com.avion.avion.Modele.Compagnie;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class GestionToken {
  private String secretcode = "miora";

  public String generateToken(Compagnie admin) {
    String jwtToken = null;
    jwtToken = Jwts.builder().signWith(SignatureAlgorithm.HS256, secretcode)
        .setIssuedAt(new Date(System.currentTimeMillis()))
        .setExpiration(new Date(System.currentTimeMillis() + 3000000)).claim("adminid", admin.getId()).compact();
    return jwtToken;
  }

  public Date expirationdateToken(String token) {
    return Jwts.parser().setSigningKey(secretcode)
        .parseClaimsJws(token).getBody().getExpiration();
  }

  public Claims testTokenClaims(String token) throws Exception {
    //final String authorizationHeaderValue = request.getHeader("Authorization");
    //String[] tokenParse = authorizationHeaderValue.split("Bearer ");
    Claims cl = null;
    if (token != null) {
      try {
        cl = Jwts.parser().setSigningKey(secretcode)
            .parseClaimsJws(token).getBody();
      } catch (Exception e) {
        throw new Exception("Token Expired");
      }
    } else {
      throw new Exception("Token Invalid");
    }
    return cl;

  }

}
