/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.antero.tankkitietokanta.db;

import com.antero.tankkitietokanta.model.Tankki;
import com.antero.tankkitietokanta.model.Valmistaja;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.catalina.ant.ValidatorTask;
import util.MyLogger;

/**
 *
 * @author Antero Oikkonen
 */
public class ValmistajaDaoImpl implements ValmistajaDao {

    private static Logger logger = MyLogger.getLogger(ValmistajaDaoImpl.class.getName());

    @Override
    public Valmistaja haeValmistaja(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<Valmistaja> haeValmistajat() {
        Connection con = TietokantaYhteys.annaYhteys();
        PreparedStatement kysely = null;
        ResultSet tulokset = null;
        Collection<Valmistaja> valmistajat = new ArrayList<Valmistaja>(50);
        StringBuffer sql = new StringBuffer("select uid,nimi,paikkakunta from valmistaja order by nimi");

        try {
            kysely = con.prepareStatement(sql.toString());
            tulokset = kysely.executeQuery();
            while (tulokset.next()) {
                Valmistaja v = new Valmistaja();
                v.setUid(tulokset.getInt("uid"));
                v.setNimi(tulokset.getString("nimi"));
                v.setPaikkakunta(tulokset.getString("paikkakunta"));

                valmistajat.add(v);

            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "sql lauseen suoritus epäonnistui", e);
        } finally {
            try {
                tulokset.close();
                kysely.close();
                con.close();
            } catch (SQLException e) {
            }

        }
        return valmistajat;
    }

    @Override
    public Collection<Valmistaja> haeValmistaja(String nimi) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int lisaaValmistaja(Valmistaja v) {
        Connection con = TietokantaYhteys.annaYhteys();
        PreparedStatement kysely = null;
        ResultSet result = null;
        int id = -1;

        StringBuffer sql = new StringBuffer("insert into valmistaja (nimi,paikkakunta)");
        sql.append(" values(?,?) RETURNING uid");

        logger.info("lisäyslause " + sql);

        try {
            kysely = con.prepareStatement(sql.toString());
            kysely.setString(1, v.getNimi());
            kysely.setString(2, v.getPaikkakunta());

            result = kysely.executeQuery();

            id = result.getInt(1);
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "sql lauseen suoritus epäonnistui", e);
        } finally {
            try {
                kysely.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(TankkiDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return id;
    }

}
