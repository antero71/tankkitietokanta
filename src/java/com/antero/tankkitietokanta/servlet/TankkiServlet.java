/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.antero.tankkitietokanta.servlet;

import com.antero.tankkitietokanta.db.TankkiDao;
import com.antero.tankkitietokanta.db.TankkiDaoImpl;
import com.antero.tankkitietokanta.model.Kayttaja;
import com.antero.tankkitietokanta.model.Tankki;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import util.MyLogger;

/**
 *
 * @author Antero Oikkonen
 */
public class TankkiServlet extends HttpServlet {

    private static Logger logger = MyLogger.getLogger(TankkiServlet.class.getName());

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

        HttpSession session = request.getSession();
        Kayttaja kirjautunut = (Kayttaja) session.getAttribute("kirjautunut");
        if (kirjautunut != null) {
            //Koodia, jonka vain kirjautunut käyttäjä saa suorittaa
        } else {
            // listaa tankit

        }

        String idParam = request.getParameter("uid");
        int id;
        try {
            id = Integer.parseInt(idParam);
            logger.info("id = " + id);

            TankkiDao tankkiDao = new TankkiDaoImpl();
            Tankki t = tankkiDao.haeTankki(id);

            logger.info("tankki = " + t.getNimi());

            request.setAttribute("tankki", t);

            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/tankki.jsp");
            /* Pyydetään dispatcher-oliota näyttämään JSP-sivunsa */
            dispatcher.forward(request, response);
            if (t != null) {
                return;
            }

        } catch (Exception e) {
            // Id-numero nolla ei käytännössä koskaan löydy kannasta, 
            // joten koodin suoritus päätyy
            // alla olevan if-lauseen else-haaraan
            id = 0;
            logger.info("id:tä ei löytynyt");
        }

        TankkiDao tankkiDao = new TankkiDaoImpl();
        Collection<Tankki> tankit = tankkiDao.haeTankit();

        request.setAttribute("tankit", tankit);

        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/tankkilista.jsp");
        /* Pyydetään dispatcher-oliota näyttämään JSP-sivunsa */
        dispatcher.forward(request, response);

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
