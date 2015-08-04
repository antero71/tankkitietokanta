/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.antero.tankkitietokanta.db;

import com.antero.tankkitietokanta.model.Kayttaja;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Antero Oikkonen
 */
public class KayttajaDaoImpl implements KayttajaDao {

    @Override
    public Kayttaja haeKayttaja(String tunnus) {
        Connection con = TietokantaYhteys.annaYhteys();
        PreparedStatement kysely = null;
        ResultSet tulokset = null;

        try {
            //Alustetaan muuttuja jossa on Select-kysely, joka palauttaa lukuarvon:
            String sqlkysely = "SELECT tunnus,salasana from kayttaja order by nimi desc";

            kysely = con.prepareStatement(sqlkysely);
            tulokset = kysely.executeQuery();
            while (tulokset.next()) {
                //Tuloksen arvoksi pitäisi tulla numero kaksi.
                String n = tulokset.getString("nimi");
                String salasana = tulokset.getString("salasana");
                Kayttaja k = new Kayttaja(tunnus,salasana);
                return k;

            }
        } catch (Exception e) {
            System.out.println("Virhe: " + e.getMessage());
        }
        return null;
    }

}
