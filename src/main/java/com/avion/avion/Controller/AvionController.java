package com.vehicule.vehicule.Controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vehicule.vehicule.Gestiontoken.GestionToken;
import com.vehicule.vehicule.Model.Avion;
import java.util.Map;
import java.util.HashMap;

import io.jsonwebtoken.Claims;

import com.vehicule.vehicule.Repository.AvionRepository;


@Controller
public class AvionController {
  

    @Autowired
    private AvionRepository avion;

  

    //modification vehicule
    @RequestMapping(value = "/MadaSky/avions/id/update/{token}" , method = RequestMethod.PUT,produces="application/json")
	@ResponseBody
    public Map<String,String> updatePhotoAvion(HttpServletRequest request,(@PathVariable("token") String token)
    {
       Avion a = new Avion();
        GestionToken tok=new GestionToken();
        try {
        Claims cl=tok.testTokenClaims(token);
        a.setId(Integer.parseInt(request.getParameter("id")));
        a.setPhoto(request.getParameter("photo"));
            map.put("data",  avion.updatePhotoAvion(a);
        } catch (Exception e) {
            map.put("error", e.getMessage());
        }
        return map;
    }




}
