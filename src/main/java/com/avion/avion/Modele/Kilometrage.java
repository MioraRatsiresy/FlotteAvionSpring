/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avion.avion.Modele;

/**
 *
 * @author Mbola
 */
public class Kilometrage {
    private int avionId;
    private String datedecollage;
    private String dateatterrissage;
    private double kilometredebut;
    private double kmfin;

    /**
     * @return the avionId
     */
    public int getAvionId() {
        return avionId;
    }

    /**
     * @param avionId the avionId to set
     */
    public void setAvionId(int avionId) {
        this.avionId = avionId;
    }

    /**
     * @return the datedecollage
     */
    public String getDatedecollage() {
        return datedecollage;
    }

    /**
     * @param datedecollage the datedecollage to set
     */
    public void setDatedecollage(String datedecollage) {
        this.datedecollage = datedecollage;
    }

    /**
     * @return the dateatterrissage
     */
    public String getDateatterrissage() {
        return dateatterrissage;
    }

    /**
     * @param dateatterrissage the dateatterrissage to set
     */
    public void setDateatterrissage(String dateatterrissage) {
        this.dateatterrissage = dateatterrissage;
    }

    /**
     * @return the kilometredebut
     */
    public double getKilometredebut() {
        return kilometredebut;
    }

    /**
     * @param kilometredebut the kilometredebut to set
     */
    public void setKilometredebut(double kilometredebut) {
        this.kilometredebut = kilometredebut;
    }

    /**
     * @return the kmfin
     */
    public double getKmfin() {
        return kmfin;
    }

    /**
     * @param kmfin the kmfin to set
     */
    public void setKmfin(double kmfin) {
        this.kmfin = kmfin;
    }
}
