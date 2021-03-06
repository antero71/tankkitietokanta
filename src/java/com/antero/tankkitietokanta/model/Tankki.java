/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.antero.tankkitietokanta.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

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
    private boolean kelvollinen = true;
    private HashMap<String, String> virheet = new HashMap<String, String>();
    
    private Collection<OsanValmistaja> osanValmistajat = new ArrayList();

    public Collection<OsanValmistaja> getOsanValmistajat() {
        return osanValmistajat;
    }

    public void setOsanValmistajat(Collection<OsanValmistaja> osanValmistajat) {
        this.osanValmistajat = osanValmistajat;
    }

    
    
    
    public boolean isKelvollinen() {
        return kelvollinen;
    }

    public HashMap<String, String> getVirheet() {
        return virheet;
    }

    public void setVirheet(HashMap<String, String> virheet) {
        this.virheet = virheet;
    }

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
        if (tarkistaString("nimi", nimi)) {
            this.nimi = nimi;
        }

    }

    public String getTyyppi() {
        return tyyppi;
    }

    public void setTyyppi(String tyyppi) {
        if (tarkistaString("tyyppi", tyyppi)) {
            this.tyyppi = tyyppi;
        }

    }

    public String getTykki() {
        return tykki;
    }

    public void setTykki(String tykki) {
        if (tarkistaString("tykki", tykki)) {
            this.tykki = tykki;
        }

    }

    public int getPituus() {
        return pituus;
    }

    public void setPituus(int pituus) {
        if (tarkastaInt("pituus", pituus)) {
            this.pituus = pituus;
        }

    }

    public int getLeveys() {
        return leveys;
    }

    public void setLeveys(int leveys) {
        if (tarkastaInt("leveys", leveys)) {
            this.leveys = leveys;
        }
    }

    public int getKorkeus() {
        return korkeus;
    }

    public void setKorkeus(int korkeus) {
        if (tarkastaInt("korkeus", korkeus)) {
            this.korkeus = korkeus;
        }
    }

    public int getRunkoEtu() {
        return runkoEtu;
    }

    public void setRunkoEtu(int runkoEtu) {
        if (tarkastaInt("runkoEtu", runkoEtu)) {
            this.runkoEtu = runkoEtu;
        }
    }

    public int getRunkoSivu() {
        return runkoSivu;
    }

    public void setRunkoSivu(int runkoSivu) {
        if (tarkastaInt("runkoSivu", runkoSivu)) {
            this.runkoSivu = runkoSivu;
        }
    }

    public int getRunkoTaka() {
        return runkoTaka;
    }

    public void setRunkoTaka(int runkoTaka) {
        if (tarkastaInt("runkoTaka", runkoTaka)) {
            this.runkoTaka = runkoTaka;
        }
    }

    public int getTorniEtu() {
        return torniEtu;
    }

    public void setTorniEtu(int torniEtu) {
        if (tarkastaInt("torniEtu", torniEtu)) {
            this.torniEtu = torniEtu;
        }
    }

    public int getTorniSivu() {
        return torniSivu;
    }

    public void setTorniSivu(int torniSivu) {
        if (tarkastaInt("torniSivu", torniSivu)) {
            this.torniSivu = torniSivu;
        }
    }

    public int getTorniTaka() {

        return torniTaka;
    }

    public void setTorniTaka(int torniTaka) {
        if (tarkastaInt("torniTaka", torniTaka)) {
            this.torniTaka = torniTaka;
        }
    }

    public int getPaino() {
        return paino;
    }

    public void setPaino(int paino) {
        if (tarkastaInt("paino", paino)) {
            this.paino = paino;
        }
    }

    public String getMoottori() {
        return moottori;
    }

    public void setMoottori(String moottori) {
        if (tarkistaString("moottori", moottori)) {
            this.moottori = moottori;
        }
    }

    public int getTeho() {
        return teho;
    }

    public void setTeho(int teho) {
        if (tarkastaInt("teho", teho)) {
            this.teho = teho;
        }
    }

    public String getLisatietoja() {
        return lisatietoja;
    }

    public void setLisatietoja(String lisatietoja) {
        if (tarkistaString("lisatietoja", lisatietoja)) {
            this.lisatietoja = lisatietoja;
        }
    }

    private boolean tarkistaString(String kentta, String sisalto) {
        if (sisalto == null) {
            virheet.put(kentta, "nimi on null");
            kelvollinen = false;
            return false;
        }

        if (sisalto.length() < 1) {
            virheet.put(kentta, "nimen pitää olla pituudeltaan yli 0");
            kelvollinen = false;
        }

        if (sisalto.contains(">") || sisalto.contains("<")) {
            virheet.put(kentta, "> ja < on kiellettyjä merkkejä");
            kelvollinen = false;
        }
        return kelvollinen;
    }

    private boolean tarkastaInt(String kentta, int arvo) {
        if (arvo < 0) {
            virheet.put(kentta, "arvo ei voi olla negatiivinen");
            kelvollinen = false;
        }

        if (arvo > 100000) {
            virheet.put(kentta, "arvon tulee olla alle 100000");
            kelvollinen = false;
        }
        return kelvollinen;
    }

    public void lisaaVirhe(String kentta, String virhe) {
        virheet.put(kentta, virhe);
        kelvollinen = false;
    }

    @Override
    public String toString() {
        return "Tankki{" + "uid=" + uid + ", nimi=" + nimi + ", tyyppi=" + tyyppi + ", tykki=" + tykki + ", pituus=" + pituus + ", leveys=" + leveys + ", korkeus=" + korkeus + ", runkoEtu=" + runkoEtu + ", runkoSivu=" + runkoSivu + ", runkoTaka=" + runkoTaka + ", torniEtu=" + torniEtu + ", torniSivu=" + torniSivu + ", torniTaka=" + torniTaka + ", paino=" + paino + ", moottori=" + moottori + ", teho=" + teho + ", lisatietoja=" + lisatietoja + ", kelvollinen=" + kelvollinen + ", virheet=" + virheet + ", osanValmistajat=" + osanValmistajat + '}';
    }
    
    

}
