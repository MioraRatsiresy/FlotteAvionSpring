package com.avion.avion.Repository;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMAvionapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.avion.avion.DAO.AvionDAO;
import com.avion.avion.Model.Avion;

@Repository
public class AvionRepository implements AvionDAO{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void updatePhotoAvion(Avion avion)
    {
        String sql = "update avion set photo='"+avion.getPhoto()+"' where id="+avion.getId();
        jdbcTemplate.update(sql);
    }

}