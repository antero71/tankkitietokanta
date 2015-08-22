/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.antero.tankkitietokanta.servlet;

import com.antero.tankkitietokanta.db.TankkiDao;
import com.antero.tankkitietokanta.db.TankkiDaoImpl;
import com.antero.tankkitietokanta.model.Tankki;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import util.JSPUtil;
import util.MyLogger;

/**
 *
 * @author Antero Oikkonen
 */
public class TankinHaku extends HttpServlet {

    private static Logger logger = MyLogger.getLogger(TankinHaku.class.getName());

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

        String hae = request.getParameter("hae");

        logger.info("hae " + hae);

        String hakukentta = request.getParameter("hakukentta");

        logger.info("hakukentän sisältö " + hakukentta);

        if (hae != null && hae.equals("true")) {
            JSPUtil.naytaJSP(request, response, "WEB-INF/jsp/haku.jsp");
            return;
        }

        TankkiDao tankkiDao = new TankkiDaoImpl();
        Collection<Tankki> tankit = null;
        logger.info("hakukentta ennen haarautumista " + hakukentta);
        logger.info("session tehtyHaku " + session.getAttribute("tehtyHaku"));

        String lista = request.getParameter("lista");

        if (lista == null && (hakukentta != null || session.getAttribute("tehtyHaku") != null)) {

            if (hakukentta == null) {
                hakukentta = (String) session.getAttribute("tehtyHaku");
            }
            logger.info("haeNimella(" + hakukentta + ")");
            session.setAttribute("tehtyHaku", hakukentta);
            tankit = tankkiDao.haeNimella(hakukentta);
        } else {
            logger.info("haeTankit()");
            session.setAttribute("tehtyHaku", null);
            tankit = tankkiDao.haeTankit();
        }

        request.setAttribute("tankit", tankit);

        JSPUtil.naytaJSP(request, response, "WEB-INF/jsp/tankkilista.jsp");

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
