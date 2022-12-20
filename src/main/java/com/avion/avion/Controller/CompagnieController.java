package com.avion.avion.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.avion.avion.Gestiontoken.GestionToken;
import com.avion.avion.Modele.Compagnie;
import com.avion.avion.Repository.CompagnieRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class CompagnieController {
    @Autowired
    private CompagnieRepository admin;

    /*LOGIN*/
    @RequestMapping(value = "/MadaSky/login/traitement" , method = RequestMethod.POST,produces="application/json")
	@ResponseBody
    @CrossOrigin
    public Map<String,String> login(HttpServletRequest request){
        Map<String,String> map=new HashMap<>();
        String status=null;
        String retour="";
        String email=request.getParameter("email");
        String pwd=request.getParameter("pwd");     
        System.out.println("E-mail : "+email);
        System.out.println("Mot de passe : "+pwd);   
        ArrayList<Compagnie> resultat=admin.login(email, pwd);
        for(int i=0; i<resultat.size();i++){
            System.out.println(resultat.get(i).getEmail());
        }
        if(resultat.size()==1){
            HttpSession session = request.getSession();
            session.setAttribute("idAdmin", resultat.get(0).getId());
            GestionToken tok=new GestionToken();
            map.put("token",tok.generateToken(resultat.get(0)));
            map.put("date d'expiration",tok.expirationdateToken(tok.generateToken(resultat.get(0))).toString());
            retour="Login correcte";
            status="succes";
        }
        else{
            retour="Login incorrecte";
            status="erreur";
        }
        map.put("message",retour);
        map.put("status",status);
        return map;
    }

    /*LOGOUT*/

    @RequestMapping(value = "/MadaSky/logout" , method = RequestMethod.GET,produces="application/json")
	@ResponseBody
    @CrossOrigin
    public Map<String,String> deconnexion(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.invalidate();
        Map<String,String> map=new HashMap<>();
        map.put("message","Logout with success");
        map.put("status","200");
        return map;
    }
}
