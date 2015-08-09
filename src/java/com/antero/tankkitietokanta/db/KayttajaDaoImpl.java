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
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.MyLogger;

/**
 *
 * @author Antero Oikkonen
 */
public class KayttajaDaoImpl implements KayttajaDao {

    private static Logger logger = MyLogger.getLogger(KayttajaDaoImpl.class.getName());

    @Override
    public Kayttaja haeKayttaja(String tunnus) {
        Connection con = TietokantaYhteys.annaYhteys();
        PreparedStatement kysely = null;
        ResultSet tulokset = null;

        try {
            //Alustetaan muuttuja jossa on Select-kysely, joka palauttaa lukuarvon:
            String sqlkysely = "SELECT tunnus,salasana from kayttaja where tunnus = ?";

            logger.info("kysely " + kysely);

            kysely = con.prepareStatement(sqlkysely);
            kysely.setString(1, tunnus);
            tulokset = kysely.executeQuery();
            while (tulokset.next()) {
                logger.info("käyttäjän haku onnistui");
                //Tuloksen arvoksi pitäisi tulla numero kaksi.
                String n = tulokset.getString("tunnus");
                String salasana = tulokset.getString("salasana");
                Kayttaja k = new Kayttaja(n, salasana);
                return k;

            }
        } catch (Exception e) {
            logger.log(Level.SEVERE, null, e);
        } finally {
            try {
                tulokset.close();
                kysely.close();
                con.close();
            } catch (SQLException ex) {
                logger.log(Level.SEVERE, null, ex);
            }

        }
        return null;
    }

}
