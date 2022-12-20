package com.avion.avion.Repository;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.avion.avion.DAO.V_AssuranceDAO;
import com.avion.avion.Modele.V_Assurance;

@Repository
public class V_AssuranceRepository implements V_AssuranceDAO{
    @Autowired
    private JdbcTemplate jdbcTemplate;

	@Override
	public ArrayList<V_Assurance> getAll() {
		String sql ="select *from v_assurance";
        return (ArrayList<V_Assurance>) jdbcTemplate.query(sql,new BeanPropertyRowMapper<V_Assurance>(V_Assurance.class));
	}

	@Override
	public ArrayList<V_Assurance> getAvionExpire1Mois() {
		String sql ="select *from v_avionExpire1Mois";
        return (ArrayList<V_Assurance>) jdbcTemplate.query(sql,new BeanPropertyRowMapper<V_Assurance>(V_Assurance.class));

	}

    @Override
	public ArrayList<V_Assurance> getAvionExpire3Mois() {
		String sql ="select *from v_avionExpire3Mois";
        return (ArrayList<V_Assurance>) jdbcTemplate.query(sql,new BeanPropertyRowMapper<V_Assurance>(V_Assurance.class));

	}
}