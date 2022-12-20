package com.vehicule.vehicule.Repository;

import java.util.ArrayList;

import com.avion.avion.DAO.KilometrageDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class KilometrageRepository implements KilometrageDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public ArrayList<KilometrageVehicule> detailKilometrage(int id){
        String sql = "select a.nom, k.dateDecolage, k.dateAtterrissage,k.kilometredebut, k.kmFin from Kilometrage k join avion a on a.id=k.avionid where avionid="+id;
        return  (ArrayList<KilometrageVehicule>) jdbcTemplate.query(sql,new BeanPropertyRowMapper<KilometrageVehicule>(KilometrageVehicule.class));
    }

    
}
