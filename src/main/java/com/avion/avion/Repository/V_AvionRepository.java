package com.avion.avion.Repository;

import java.util.ArrayList;

import com.avion.avion.DAO.V_AvionDAO;
import com.avion.avion.Modele.V_Avion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class V_AvionRepository implements V_AvionDAO{

    @Autowired
    private JdbcTemplate jdbcTemplate;
    
	@Override
	public ArrayList<V_Avion> liste() {
		String sql = "select*from v_avion";
        return (ArrayList<V_Avion>) jdbcTemplate.query(sql,new BeanPropertyRowMapper<V_Avion>(V_Avion.class));
	}

	@Override
	public ArrayList<V_Avion> getDetailAvion(int id) {
		String sql = "select*from v_avion where id="+id;
        return (ArrayList<V_Avion>) jdbcTemplate.query(sql,new BeanPropertyRowMapper<V_Avion>(V_Avion.class));
	}
   
}
