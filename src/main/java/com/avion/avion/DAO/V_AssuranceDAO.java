package com.avion.avion.DAO;
import java.util.ArrayList;

import com.avion.avion.Model.V_Assurance;


public interface V_AssuranceDAO {
    ArrayList<V_Assurance> getAll();
    ArrayList<V_Assurance> getAvionExpire1Mois();
    ArrayList<V_Assurance> getAvionExpire3Mois();
}
