/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.antero.tankkitietokanta.servlet;

import com.antero.tankkitietokanta.db.KayttajaDao;
import com.antero.tankkitietokanta.db.KayttajaDaoImpl;
import com.antero.tankkitietokanta.db.TietokantaYhteys;
import com.antero.tankkitietokanta.model.Kayttaja;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import util.MyLogger;

/**
 *
 * @author Antero Oikkonen
 */
public class LoginServlet extends HttpServlet {

    private static Logger logger = MyLogger.getLogger(LoginServlet.class.getName());

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

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            /* TODO output your page here. You may use following sample code. */
            String salasana = request.getParameter("password");
            String tunnus = request.getParameter("username");

            logger.info("sivulta salasana " + salasana);
            logger.info("sivulta tunnus " + tunnus);
            Kayttaja k = null;
            if (tunnus != null && salasana != null) {

                try {

                    KayttajaDao kayttaja = new KayttajaDaoImpl();
                    k = kayttaja.haeKayttaja(tunnus);
                } catch (Exception e) {
                    logger.log(Level.SEVERE, "Tietokantavirhe", e);
                }
                logger.info("kayttaja " + k);
            }
            /* Tarkistetaan onko parametrina saatu oikeat tunnukset */
            if (k != null && k.getTunnus() != null && k.getSalanasa() != null && k.getTunnus().equals(tunnus) && k.getSalanasa().equals(salasana)) {
                /* Jos tunnus on oikea, ohjataan käyttäjä HTTP-ohjauksella kissalistaan. */
                response.sendRedirect("kissalista");
            } else {
                logger.info("kayttaja " + k + ", login.jsp seuraavaksi");
                /* Väärän tunnuksen syöttänyt saa eteensä kirjautumislomakkeen.
                 */
                RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/login.jsp");
                /* Pyydetään dispatcher-oliota näyttämään JSP-sivunsa */
                dispatcher.forward(request, response);
            }
            logger.info("tänne ei pitäis mennä");
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
