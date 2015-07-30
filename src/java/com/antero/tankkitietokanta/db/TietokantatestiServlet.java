/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.antero.tankkitietokanta.db;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Antero Oikkonen
 */
@WebServlet(name = "TietokantatestiServlet", urlPatterns = {"/TietokantatestiServlet"})
public class TietokantatestiServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Connection yhteys = TietokantaYhteys.annaYhteys(); //Haetaan tietokantaluokalta yhteysolio
            PreparedStatement kysely = null;
            ResultSet tulokset = null;
            PrintWriter out = response.getWriter();
            response.setContentType("text/plain;charset=UTF-8");
            
            try {
                //Alustetaan muuttuja jossa on Select-kysely, joka palauttaa lukuarvon:
                String sqlkysely = "SELECT nimi from testi order by nimi desc";
                
                kysely = yhteys.prepareStatement(sqlkysely);
                tulokset = kysely.executeQuery();
                while (tulokset.next()) {
                    //Tuloksen arvoksi pitäisi tulla numero kaksi.
                    String tulos = tulokset.getString("nimi");
                    out.println("Tulos: " + tulos);
                }
            } catch (Exception e) {
                out.println("Virhe: " + e.getMessage());
            }
            
            tulokset.close();
            kysely.close();
        } catch (SQLException ex) {
            Logger.getLogger(TietokantatestiServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}