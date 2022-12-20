package com.avion.avion.Modele;
public class Avion {
    int id,Constructeurid;
    String nom,photo;
    float longueur,hauteur;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getConstructeurid() {
        return Constructeurid;
    }

    public void setConstructeurid(int Constructeurid) {
        this.Constructeurid = Constructeurid;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public float getLongueur() {
        return longueur;
    }

    public void setLongueur(float longueur) {
        this.longueur = longueur;
    }

    public float getHauteur() {
        return hauteur;
    }

    public void setHauteur(float hauteur) {
        this.hauteur = hauteur;
    }
    
}
