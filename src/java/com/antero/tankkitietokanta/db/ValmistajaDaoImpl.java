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
        Connection con = TietokantaYhteys.annaYhteys();
        PreparedStatement kysely = null;
        ResultSet tulokset = null;
        Valmistaja v = new Valmistaja();
        StringBuffer sql = new StringBuffer("select uid,nimi,paikkakunta from valmistaja where uid=?");
        logger.info("hakulause " + sql);
        try {
            kysely = con.prepareStatement(sql.toString());
            kysely.setInt(1, id);
            tulokset = kysely.executeQuery();
            if (tulokset.next()) {

                v.setUid(tulokset.getInt("uid"));
                v.setNimi(tulokset.getString("nimi"));
                v.setPaikkakunta(tulokset.getString("paikkakunta"));

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
        return v;
    }

    @Override
    public Collection<Valmistaja> haeValmistajat() {
        Connection con = TietokantaYhteys.annaYhteys();
        PreparedStatement kysely = null;
        ResultSet tulokset = null;
        Collection<Valmistaja> valmistajat = new ArrayList<Valmistaja>(50);
        StringBuffer sql = new StringBuffer("select uid,nimi,paikkakunta from valmistaja order by nimi");
        logger.info("hakulause " + sql);
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
        logger.info("valmistajia löytyi " + valmistajat.size());
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

            if (result.next()) {
                id = result.getInt(1);
            }
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

    @Override
    public int paivitaValmistaja(Valmistaja v) {
        StringBuffer sql = new StringBuffer("update valmistaja set nimi=?,paikkakunta=?");
        sql.append(" where uid=?");

        logger.info("sql " + sql);

        Connection con = TietokantaYhteys.annaYhteys();
        PreparedStatement kysely = null;
        try {
            kysely = con.prepareStatement(sql.toString());

            kysely.setString(1, v.getNimi());
            kysely.setString(2, v.getPaikkakunta());
            kysely.setInt(3, v.getUid());

            kysely.executeQuery();
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, null, ex);
        } finally {
            try {
                kysely.close();
                con.close();
            } catch (SQLException ex) {
                logger.log(Level.SEVERE, null, ex);
            }

        }
        return v.getUid();

    }

    @Override
    public void poistaValmistaja(int id) {
        String sql = "delete from valmistaja where uid=?";

        logger.info("deletestring " + sql);
        logger.info("poistettavan id " + id);

        Connection con = TietokantaYhteys.annaYhteys();
        PreparedStatement kysely = null;
        try {
            kysely = con.prepareStatement(sql);

            kysely.setInt(1, id);

            kysely.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(TankkiDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                kysely.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(TankkiDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

}
