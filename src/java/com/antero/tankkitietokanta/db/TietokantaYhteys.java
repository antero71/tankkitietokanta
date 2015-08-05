/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.antero.tankkitietokanta.db;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import util.MyLogger;

/**
 *
 * @author Antero Oikkonen
 */
public class TietokantaYhteys {

    private static Logger logger = MyLogger.getLogger(TietokantaYhteys.class.getName());

    public static Connection annaYhteys() {
       
        try {
            InitialContext cxt = new InitialContext();
            logger.info("seuraavaksi ctx.lookup");
            DataSource yhteysVarasto = (DataSource) cxt.lookup("java:/comp/env/jdbc/tietokanta");
            try {
                return yhteysVarasto.getConnection();
                //return yhteysVarasto;
            } catch (SQLException ex) {
                logger.log(Level.SEVERE, null, ex);
                logger.severe("SQLException " + ex.getCause());
            }
        } catch (NamingException ex) {
            logger.log(Level.SEVERE, null, ex);
            logger.severe("NamingException " + ex.getCause());
        }
        logger.info("seuraavaksi return null");

        return null;
    }
}
