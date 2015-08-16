/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.antero.tankkitietokanta.db;

import com.antero.tankkitietokanta.model.Valmistaja;
import java.util.Collection;

/**
 *
 * @author Antero Oikkonen
 */
public interface ValmistajaDao {
    public Valmistaja haeValmistaja(int id);
    public Collection<Valmistaja> haeValmistajat();
    public Collection<Valmistaja> haeValmistaja(String nimi);
    public int lisaaValmistaja(Valmistaja v);
    
}
