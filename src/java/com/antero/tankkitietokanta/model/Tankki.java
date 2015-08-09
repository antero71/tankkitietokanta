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
public class Tankki {

    private int uid;
    private String nimi;
    private String tyyppi;
    private String tykki;
    private int pituus;
    private int leveys;
    private int korkeus;
    private int runkoEtu;
    private int runkoSivu;
    private int runkoTaka;
    private int torniEtu;
    private int torniSivu;
    private int torniTaka;
    private int paino;
    private String moottori;
    private int teho;
    private String lisatietoja;

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

    public String getTyyppi() {
        return tyyppi;
    }

    public void setTyyppi(String tyyppi) {
        this.tyyppi = tyyppi;
    }

    public String getTykki() {
        return tykki;
    }

    public void setTykki(String tykki) {
        this.tykki = tykki;
    }

    public int getPituus() {
        return pituus;
    }

    public void setPituus(int pituus) {
        this.pituus = pituus;
    }

    public int getLeveys() {
        return leveys;
    }

    public void setLeveys(int leveys) {
        this.leveys = leveys;
    }

    public int getKorkeus() {
        return korkeus;
    }

    public void setKorkeus(int korkeus) {
        this.korkeus = korkeus;
    }

    public int getRunkoEtu() {
        return runkoEtu;
    }

    public void setRunkoEtu(int runkoEtu) {
        this.runkoEtu = runkoEtu;
    }

    public int getRunkoSivu() {
        return runkoSivu;
    }

    public void setRunkoSivu(int runkoSivu) {
        this.runkoSivu = runkoSivu;
    }

    public int getRunkoTaka() {
        return runkoTaka;
    }

    public void setRunkoTaka(int runkoTaka) {
        this.runkoTaka = runkoTaka;
    }

    public int getTorniEtu() {
        return torniEtu;
    }

    public void setTorniEtu(int torniEtu) {
        this.torniEtu = torniEtu;
    }

    public int getTorniSivu() {
        return torniSivu;
    }

    public void setTorniSivu(int torniSivu) {
        this.torniSivu = torniSivu;
    }

    public int getTorniTaka() {
        return torniTaka;
    }

    public void setTorniTaka(int torniTaka) {
        this.torniTaka = torniTaka;
    }

    public int getPaino() {
        return paino;
    }

    public void setPaino(int paino) {
        this.paino = paino;
    }

    public String getMoottori() {
        return moottori;
    }

    public void setMoottori(String moottori) {
        this.moottori = moottori;
    }

    public int getTeho() {
        return teho;
    }

    public void setTeho(int teho) {
        this.teho = teho;
    }

    public String getLisatietoja() {
        return lisatietoja;
    }

    public void setLisatietoja(String lisatietoja) {
        this.lisatietoja = lisatietoja;
    }

}
