/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.antero.tankkitietokanta.db;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author Antero Oikkonen
 */
public class TietokantaYhteys {

    public static Connection annaYhteys() {
        try {
            InitialContext cxt = new InitialContext();
            DataSource yhteysVarasto = (DataSource) cxt.lookup("java:/comp/env/jdbc/tietokanta");
            try {
                return yhteysVarasto.getConnection();
                //return yhteysVarasto;
            } catch (SQLException ex) {
                Logger.getLogger(TietokantaYhteys.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (NamingException ex) {
            Logger.getLogger(TietokantaYhteys.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
