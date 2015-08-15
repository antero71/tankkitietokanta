/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.antero.tankkitietokanta.db;

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
public class TankkiDaoImpl implements TankkiDao {

    private static Logger logger = MyLogger.getLogger(TankkiDaoImpl.class.getName());

    @Override
    public Collection<Tankki> haeTankit() {
        Connection con = TietokantaYhteys.annaYhteys();
        PreparedStatement kysely = null;
        ResultSet tulokset = null;
        Collection<Tankki> tankit = new ArrayList<Tankki>(50);
        StringBuffer sql = new StringBuffer("select uid,nimi,tyyppi,tykki,pituus");
        sql.append(",leveys,korkeus,runko_etu");
        sql.append(",runko_sivu,runko_taka,torni_etu,torni_sivu,torni_taka,paino");
        sql.append(",moottori,teho,lisatietoja from tankki order by nimi");

        try {
            kysely = con.prepareStatement(sql.toString());
            tulokset = kysely.executeQuery();
            while (tulokset.next()) {
                logger.info("tankin haku onnistui");
                Tankki t = new Tankki();
                //Tuloksen arvoksi pitäisi tulla numero kaksi.

                t.setUid(tulokset.getInt("uid"));

                t.setNimi(tulokset.getString("nimi"));
                t.setTyyppi(tulokset.getString("tyyppi"));
                t.setTykki(tulokset.getString("tykki"));
                t.setPituus(tulokset.getInt("pituus"));
                t.setLeveys(tulokset.getInt("leveys"));
                t.setKorkeus(tulokset.getInt("korkeus"));
                t.setRunkoEtu(tulokset.getInt("runko_etu"));
                t.setRunkoSivu(tulokset.getInt("runko_sivu"));
                t.setRunkoTaka(tulokset.getInt("runko_taka"));
                t.setTorniEtu(tulokset.getInt("torni_etu"));
                t.setTorniSivu(tulokset.getInt("torni_sivu"));
                t.setTorniTaka(tulokset.getInt("torni_taka"));
                t.setPaino(tulokset.getInt("paino"));
                t.setMoottori(tulokset.getString("moottori"));
                t.setTeho(tulokset.getInt("teho"));
                t.setLisatietoja(tulokset.getString("lisatietoja"));

                tankit.add(t);

            }
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, null, ex);
        } finally {
            try {
                tulokset.close();

                kysely.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(TankkiDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return tankit;
    }

    @Override
    public Tankki haeTankki(String nimi) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Tankki haeTankki(int id) {
        Connection con = TietokantaYhteys.annaYhteys();
        PreparedStatement kysely = null;
        ResultSet tulokset = null;
        Tankki t = new Tankki();
        StringBuffer sql = new StringBuffer("select uid,nimi,tyyppi,tykki,pituus");
        sql.append(",leveys,korkeus,runko_etu");
        sql.append(",runko_sivu,runko_taka,torni_etu,torni_sivu,torni_taka,paino");
        sql.append(",moottori,teho,lisatietoja from tankki where uid = ?");

        logger.info("hae tankki kysely " + sql);

        try {
            kysely = con.prepareStatement(sql.toString());
            kysely.setInt(1, id);

            tulokset = kysely.executeQuery();
            while (tulokset.next()) {
                logger.info("tankin haku onnistui id:llä " + id);

                //Tuloksen arvoksi pitäisi tulla numero kaksi.
                t.setUid(tulokset.getInt("uid"));

                t.setNimi(tulokset.getString("nimi"));
                t.setTyyppi(tulokset.getString("tyyppi"));
                t.setTykki(tulokset.getString("tykki"));
                t.setPituus(tulokset.getInt("pituus"));
                t.setLeveys(tulokset.getInt("leveys"));
                t.setKorkeus(tulokset.getInt("korkeus"));
                t.setRunkoEtu(tulokset.getInt("runko_etu"));
                t.setRunkoSivu(tulokset.getInt("runko_sivu"));
                t.setRunkoTaka(tulokset.getInt("runko_taka"));
                t.setTorniEtu(tulokset.getInt("torni_etu"));
                t.setTorniSivu(tulokset.getInt("torni_sivu"));
                t.setTorniTaka(tulokset.getInt("torni_taka"));
                t.setPaino(tulokset.getInt("paino"));
                t.setMoottori(tulokset.getString("moottori"));
                t.setTeho(tulokset.getInt("teho"));
                t.setLisatietoja(tulokset.getString("lisatietoja"));

            }
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, null, ex);
        } finally {
            try {
                tulokset.close();

                kysely.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(TankkiDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return t;
    }

    private PreparedStatement createPreparedStatement(PreparedStatement kysely, Tankki tankki) throws SQLException {
        kysely.setString(1, tankki.getNimi());
        kysely.setString(2, tankki.getTyyppi());
        kysely.setString(3, tankki.getTykki());
        kysely.setInt(4, tankki.getPituus());
        kysely.setInt(5, tankki.getLeveys());
        kysely.setInt(6, tankki.getKorkeus());
        kysely.setInt(7, tankki.getRunkoEtu());
        kysely.setInt(8, tankki.getRunkoSivu());
        kysely.setInt(9, tankki.getRunkoTaka());
        kysely.setInt(10, tankki.getTorniEtu());
        kysely.setInt(11, tankki.getTorniSivu());
        kysely.setInt(12, tankki.getTorniTaka());
        kysely.setInt(13, tankki.getPaino());
        kysely.setString(14, tankki.getMoottori());
        kysely.setInt(15, tankki.getTeho());
        kysely.setString(16, tankki.getLisatietoja());

        return kysely;

    }

    @Override
    public int lisaaTankki(Tankki tankki) {

        Connection con = TietokantaYhteys.annaYhteys();
        PreparedStatement kysely = null;
        ResultSet result = null;
        int id = -1;

        StringBuffer sql = new StringBuffer("insert into tankki (nimi,tyyppi,tykki,pituus");
        sql.append(",leveys,korkeus,runko_etu");
        sql.append(",runko_sivu,runko_taka,torni_etu,torni_sivu,torni_taka,paino");
        sql.append(",moottori,teho,lisatietoja) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) RETURNING uid");

        logger.info("lisäyslause " + sql);

        try {
            kysely = con.prepareStatement(sql.toString());

            kysely = createPreparedStatement(kysely, tankki);

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

    @Override
    public int paivitaTankki(Tankki tankki) {
        StringBuffer sql = new StringBuffer("update tankki set nimi=?,tyyppi=?,tykki=?,pituus=?");
        sql.append(",leveys=?,korkeus=?,runko_etu=?");
        sql.append(",runko_sivu=?,runko_taka=?,torni_etu=?,torni_sivu=?,torni_taka=?,paino=?");
        sql.append(",moottori=?,teho=?,lisatietoja=? where uid=?");

        logger.info("sql " + sql);

        Connection con = TietokantaYhteys.annaYhteys();
        PreparedStatement kysely = null;
        try {
            kysely = con.prepareStatement(sql.toString());

            kysely = createPreparedStatement(kysely, tankki);
            kysely.setInt(17, tankki.getUid());

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
        return tankki.getUid();
    }

}
