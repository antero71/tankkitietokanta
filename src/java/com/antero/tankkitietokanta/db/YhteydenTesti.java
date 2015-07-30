/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.antero.tankkitietokanta.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author Antero Oikkonen
 */
public class YhteydenTesti {
    
    public void listaaData(){
        Connection con = TietokantaYhteys.annaYhteys();
        PreparedStatement state = null;
        ResultSet result = null;
        try {
            
            state = con.prepareStatement("select nimi from testi");
            result = state.executeQuery();
            while(result.next()){
                System.out.println(result.getString("nimi"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(YhteydenTesti.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                result.close();
                state.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(YhteydenTesti.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }
    
    public static void main(String[] args) {
        YhteydenTesti testi = new YhteydenTesti();
        testi.listaaData();
    }
    
}
