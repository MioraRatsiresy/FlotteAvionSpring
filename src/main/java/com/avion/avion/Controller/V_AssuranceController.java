package com.avion.avion.Controller;

import java.util.HashMap;
import java.util.Map;

import com.avion.avion.Gestiontoken.GestionToken;
import com.avion.avion.Repository.V_AssuranceRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import io.jsonwebtoken.Claims;

@Controller
public class V_AssuranceController {
    @Autowired
    private V_AssuranceRepository avion;

   

    /*  Assurance expiré dans 1 mois */
    @RequestMapping(value = "/MadaSky/avions/1/assurance/expiration/{token}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    @CrossOrigin
    public Map<String, Object> getAvionExpire1Mois(@PathVariable("token") String token) {
        Map<String, Object> map = new HashMap<>();
        GestionToken tok=new GestionToken();
        try {
        Claims cl=tok.testTokenClaims(token);
            map.put("data", avion.getAvionExpire1Mois());
        } catch (Exception e) {
            map.put("error", e.getMessage());
        }
        return map;
    }

     /*  Assurance expiré dans 3 cmois */
     @RequestMapping(value = "/MadaSky/avions/3/assurance/expiration/{token}", method = RequestMethod.GET, produces = "application/json")
     @ResponseBody
     @CrossOrigin
     public Map<String, Object> getAvionExpire3Mois(@PathVariable("token") String token) {
         Map<String, Object> map = new HashMap<>();
         GestionToken tok=new GestionToken();
         try {
         Claims cl=tok.testTokenClaims(token);
             map.put("data", avion.getAvionExpire3Mois());
         } catch (Exception e) {
             map.put("error", e.getMessage());
         }
         return map;
     }

}