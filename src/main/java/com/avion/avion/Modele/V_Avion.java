/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avion.avion.Modele;

import java.util.ArrayList;

/**
 *
 * @author Mbola
 */
public class V_Avion {
    private int id;
    private String nom;
    private String photo;
    private double longueur;
    private double hauteur;
    private int constructeurid;
    private String constructeur;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @return the photo
     */
    public String getPhoto() {
        return photo;
    }

    /**
     * @param photo the photo to set
     */
    public void setPhoto(String photo) {
        this.photo = photo;
    }

    /**
     * @return the longueur
     */
    public double getLongueur() {
        return longueur;
    }

    /**
     * @param longueur the longueur to set
     */
    public void setLongueur(double longueur) {
        this.longueur = longueur;
    }

    /**
     * @return the hauteur
     */
    public double getHauteur() {
        return hauteur;
    }

    /**
     * @param hauteur the hauteur to set
     */
    public void setHauteur(double hauteur) {
        this.hauteur = hauteur;
    }

    /**
     * @return the constructeurid
     */
    public int getConstructeurid() {
        return constructeurid;
    }

    /**
     * @param constructeurid the constructeurid to set
     */
    public void setConstructeurid(int constructeurid) {
        this.constructeurid = constructeurid;
    }

    /**
     * @return the constructeur
     */
    public String getConstructeur() {
        return constructeur;
    }

    /**
     * @param constructeur the constructeur to set
     */
    public void setConstructeur(String constructeur) {
        this.constructeur = constructeur;
    }
    private ArrayList<Kilometrage> kilometrage;

    public ArrayList<Kilometrage> getKilometrage() {
       return kilometrage;
    }
    public void setKilometrage(ArrayList<Kilometrage> kilometrage) {
        this.kilometrage = kilometrage;
    }

}
