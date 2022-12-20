package com.avion.avion.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.avion.avion.Gestiontoken.GestionToken;
import com.avion.avion.Modele.V_Avion;
import com.avion.avion.Repository.KilometrageRepository;
import com.avion.avion.Repository.V_AvionRepository;

import io.jsonwebtoken.Claims;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class V_AvionController {
    @Autowired
    private V_AvionRepository avionrepos;

    @Autowired
    private KilometrageRepository kr;

    /*  Assurance expiré dans 3 mois */
    @RequestMapping(value = "/MadaSky/avions/liste", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    @CrossOrigin
    public Map<String, Object> getAll() {
        Map<String, Object> map = new HashMap<>();
        try {
            map.put("data", avionrepos.liste());
        } catch (Exception e) {
            map.put("error", e.getMessage());
        }
        return map;
    }

    /* DETAIL VEHICULE */
    @RequestMapping(value = "/MadaSky/avions/{id}/detail/{token}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    @CrossOrigin
    public Map<String, Object> getAllViewAvion(Model model, HttpServletRequest request,@PathVariable("id") int id,@PathVariable("token") String token) {
        Map<String, Object> map = new HashMap<>();
        GestionToken tok = new GestionToken();
        try {
            Claims cl = tok.testTokenClaims(token);
            ArrayList<V_Avion> avioninfo = avionrepos.getDetailAvion(id);
            for (int i = 0; i < avioninfo.size(); i++) {
                avioninfo.get(i).setKilometrage(kr.detailKilometrage(avioninfo.get(i).getId()));
                ;
            }
            map.put("data", avioninfo);
        } catch (Exception e) {
            map.put("erreur", e.getMessage());
        }
        return map;
    }
}