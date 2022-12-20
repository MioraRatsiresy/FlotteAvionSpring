package com.avion.avion.DAO;

import java.util.ArrayList;

import com.avion.avion.Modele.Kilometrage;


public interface KilometrageDAO {
    ArrayList<Kilometrage> detailKilometrage(int id);
}
