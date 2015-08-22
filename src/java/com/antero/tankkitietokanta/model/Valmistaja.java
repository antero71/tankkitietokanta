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
public class Valmistaja {
    private int uid;
    private String nimi;
    private String paikkakunta;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getNimi() {
        return nimi;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public String getPaikkakunta() {
        return paikkakunta;
    }

    public void setPaikkakunta(String paikkakunta) {
        this.paikkakunta = paikkakunta;
    }

    @Override
    public String toString() {
        return "Valmistaja{uid=" + uid + ", nimi=" + nimi + ", paikkakunta=" + paikkakunta + '}';
    }
    
    
}
