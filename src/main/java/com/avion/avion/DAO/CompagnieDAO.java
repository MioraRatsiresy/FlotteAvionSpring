package com.avion.avion.DAO;

import java.util.ArrayList;

import com.avion.avion.Modele.Compagnie;

public interface CompagnieDAO {
    ArrayList<Compagnie> login(String email, String pwd);
}
