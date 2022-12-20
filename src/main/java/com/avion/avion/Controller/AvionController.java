package com.avion.avion.Controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.avion.avion.Gestiontoken.GestionToken;
import com.avion.avion.Modele.Avion;
import com.avion.avion.Repository.AvionRepository;

import java.util.Map;
import java.util.HashMap;

import io.jsonwebtoken.Claims;

@Controller
public class AvionController {

    @Autowired
    private AvionRepository avion;

    // modification vehicule
    @RequestMapping(value = "/MadaSky/avions/id/update/{token}", method = RequestMethod.PUT, produces = "application/json")
    @ResponseBody
    public Map<String, Object> updatePhotoAvion(HttpServletRequest request, @PathVariable("token") String token) {
        Map<String, Object> map = new HashMap<>();
        Avion a = new Avion();
        GestionToken tok = new GestionToken();
        try {
            Claims cl = tok.testTokenClaims(token);
            a.setId(Integer.parseInt(request.getParameter("id")));
            a.setPhoto(request.getParameter("photo"));
            //update 
            avion.updatePhotoAvion(a);
            map.put("status","Update photo with succes");
        } catch (Exception e) {
            map.put("error", e.getMessage());
        }
        return map;
    }
}
