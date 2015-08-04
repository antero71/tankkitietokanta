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
    private String salanasa;

    public Kayttaja(String nimi, String salasana) {
        this.nimi=nimi;
        this.salanasa=salasana;
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
    
    
}
