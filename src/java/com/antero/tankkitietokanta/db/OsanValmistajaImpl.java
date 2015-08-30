/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.antero.tankkitietokanta.db;

import com.antero.tankkitietokanta.model.OsanValmistaja;
import com.antero.tankkitietokanta.model.Tankki;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.MyLogger;

/**
 *
 * @author Antero Oikkonen
 */
public class OsanValmistajaImpl implements OsanValmistajaDao {

    private static Logger logger = MyLogger.getLogger(OsanValmistajaImpl.class.getName());

    @Override
    public Collection<OsanValmistaja> haeTankit(int valmistajaid) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<OsanValmistaja> haeValmistajat(int tankkiId) {
        Connection con = TietokantaYhteys.annaYhteys();
        PreparedStatement kysely = null;
        ResultSet tulokset = null;
        Collection<OsanValmistaja> osanValmistajat = new ArrayList<OsanValmistaja>(50);
        StringBuffer sql = new StringBuffer("select osaid,valmistajaid,osannimi");

        sql.append(",valmistus_alkoi,valmistus_paattyi where osaid=?");

        OsanValmistaja osanValmistaja = null;

        try {
            
            kysely = con.prepareStatement(sql.toString());
            kysely.setInt(1, tankkiId);
            tulokset = kysely.executeQuery();
            while (tulokset.next()) {
                osanValmistaja = new OsanValmistaja();
                osanValmistaja.setOsaId(tulokset.getInt(1));
                osanValmistaja.setValmistajaId(tulokset.getInt(2));
                osanValmistaja.setOsanNimi(tulokset.getString(3));
                osanValmistaja.setValmistusAlkoi(tulokset.getInt(4));
                osanValmistaja.setValmistusPaattyi(tulokset.getInt(5));

                osanValmistajat.add(osanValmistaja);

            }
        } catch (SQLException e) {
            logger.logp(Level.SEVERE, OsanValmistajaImpl.class.getName(), "haeValmistajat", null, e);
        }
        return osanValmistajat;
    }

    @Override
    public void tallennaOsanValmistaja(OsanValmistaja tv) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
