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
public class TankinValmistaja {
    private int tankkiId;
    private int valmistajaId;
    private int valmistusAlkoi;
    private int valmistusPaattyi;
    private String osanNimi;

    public int getTankkiId() {
        return tankkiId;
    }

    public void setTankkiId(int tankkiId) {
        this.tankkiId = tankkiId;
    }

    public int getValmistajaId() {
        return valmistajaId;
    }

    public void setValmistajaId(int valmistajaId) {
        this.valmistajaId = valmistajaId;
    }

    public int getValmistusAlkoi() {
        return valmistusAlkoi;
    }

    public void setValmistusAlkoi(int valmistusAlkoi) {
        this.valmistusAlkoi = valmistusAlkoi;
    }

    public int getValmistusPaattyi() {
        return valmistusPaattyi;
    }

    public void setValmistusPaattyi(int valmistusPaattyi) {
        this.valmistusPaattyi = valmistusPaattyi;
    }

    public String getOsanNimi() {
        return osanNimi;
    }

    public void setOsanNimi(String osanNimi) {
        this.osanNimi = osanNimi;
    }
    
    
    
}
