package com.avion.avion.DAO;

import java.util.ArrayList;

import com.avion.avion.Modele.V_Avion;


public interface V_AvionDAO {
    ArrayList<V_Avion> liste();
    ArrayList<V_Avion> getDetailAvion(int id);
    ArrayList<V_Avion> searchAvion(String search);
}
