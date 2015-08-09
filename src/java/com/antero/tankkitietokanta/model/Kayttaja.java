/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.antero.tankkitietokanta.model;

/**
 *
 * @author Antero Oikkonen
 */
public class Kayttaja {

    private String nimi;
    private String tunnus;
    private String salanasa;

    public Kayttaja(String tunnus, String salasana) {
        this.tunnus = tunnus;
        this.salanasa = salasana;
    }

    public String getTunnus() {
        return tunnus;
    }

    public void setTunnus(String tunnus) {
        this.tunnus = tunnus;
    }

    public String getNimi() {
        return nimi;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public String getSalanasa() {
        return salanasa;
    }

    public void setSalanasa(String salanasa) {
        this.salanasa = salanasa;
    }

    @Override
    public String toString() {
        return "tunnus " + tunnus + " salasana " + salanasa;
    }

}
