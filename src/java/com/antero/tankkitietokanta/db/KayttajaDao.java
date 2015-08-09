/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.antero.tankkitietokanta.db;

import com.antero.tankkitietokanta.model.Kayttaja;

/**
 *
 * @author Antero Oikkonen
 */
public interface KayttajaDao {

    public Kayttaja haeKayttaja(String nimi);

}
