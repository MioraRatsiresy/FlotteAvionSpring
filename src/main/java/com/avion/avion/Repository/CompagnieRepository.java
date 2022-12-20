package com.avion.avion.Repository;

import java.util.ArrayList;

import com.avion.avion.DAO.CompagnieDAO;
import com.avion.avion.Modele.Compagnie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class CompagnieRepository implements CompagnieDAO{

    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    public ArrayList<Compagnie> login(String email,String pwd) {
        String sql = "select*from compagnie where email='"+email+"' and pwd=md5('"+pwd+"')";
        return (ArrayList<Compagnie>) jdbcTemplate.query(sql,new BeanPropertyRowMapper<Compagnie>(Compagnie.class));
    }
   
}
