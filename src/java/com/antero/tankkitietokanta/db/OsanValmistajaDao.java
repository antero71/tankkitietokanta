/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.antero.tankkitietokanta.db;

import com.antero.tankkitietokanta.model.OsanValmistaja;
import com.antero.tankkitietokanta.model.Tankki;
import com.antero.tankkitietokanta.model.Valmistaja;
import java.util.Collection;

/**
 *
 * @author Antero Oikkonen
 */
public interface OsanValmistajaDao {
    Collection<OsanValmistaja> haeTankit(int valmistajaid);
    Collection<OsanValmistaja> haeValmistajat(int tankkiId);
    void tallennaOsanValmistaja(OsanValmistaja tv);
}
