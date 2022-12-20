package com.avion.avion.Modele;
import java.sql.Date;
import java.sql.Timestamp;

/**
 *
 * @author Kanto
 */
public class V_Assurance {
    int id,idAssurance;
    String nom,photo,constructeur;
    Timestamp dateDecolage,dateAtterrissage;
    float longueur,hauteur,kilometre;
    Date dateAssurance,dateExpiration;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdAssurance() {
        return idAssurance;
    }

    public void setIdAssurance(int idAssurance) {
        this.idAssurance = idAssurance;
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

    public String getConstructeur() {
        return constructeur;
    }

    public void setConstructeur(String constructeur) {
        this.constructeur = constructeur;
    }

    public Timestamp getDateDecolage() {
        return dateDecolage;
    }

    public void setDateDecolage(Timestamp dateDecolage) {
        this.dateDecolage = dateDecolage;
    }

    public Timestamp getDateAtterrissage() {
        return dateAtterrissage;
    }

    public void setDateAtterrissage(Timestamp dateAtterrissage) {
        this.dateAtterrissage = dateAtterrissage;
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

    public float getKilometre() {
        return kilometre;
    }

    public void setKilometre(float kilometre) {
        this.kilometre = kilometre;
    }

    public Date getDateAssurance() {
        return dateAssurance;
    }

    public void setDateAssurance(Date dateAssurance) {
        this.dateAssurance = dateAssurance;
    }

    public Date getDateExpiration() {
        return dateExpiration;
    }

    public void setDateExpiration(Date dateExpiration) {
        this.dateExpiration = dateExpiration;
    }
    
}
