/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.antero.tankkitietokanta.db;

import com.antero.tankkitietokanta.model.Tankki;
import java.util.Collection;

/**
 *
 * @author Antero Oikkonen
 */
public interface TankkiDao {

    public Collection<Tankki> haeTankit();

    public Tankki haeTankki(String nimi);

    public Tankki haeTankki(int id);

    public int lisaaTankki(Tankki tankki);
    
    public int paivitaTankki(Tankki tankki);

    public void poistaTankki(int id);
    
    public Collection<Tankki> haeNimella(String nimi);
    
}
