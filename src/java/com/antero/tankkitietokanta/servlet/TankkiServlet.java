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
import java.util.logging.Level;
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

        String muokkaa = request.getParameter("muokkaa");

        logger.info("muokkaa " + muokkaa);

        String idParam = request.getParameter("uid");

        logger.info("uid " + idParam);

        RequestDispatcher dispatcher = null;

        String newParam = request.getParameter("new");

        logger.info("new " + newParam);

        String otsikko = request.getParameter("otsikko");
        String otsikko2 = request.getParameter("otsikko2");

        logger.info("otsikko " + otsikko);

        if (newParam != null && newParam.equals("true") && kirjautunut != null) {
            request.setAttribute("otsikko", "lisäys");
            request.setAttribute("otsikko2", "insert");
            dispatcher = request.getRequestDispatcher("WEB-INF/jsp/muokkaatankki.jsp");
            dispatcher.forward(request, response);
            return;
        }

        if (otsikko2 != null) {
            logger.info("otsikko annettu " + otsikko);
            logger.info("otsikko2 " + otsikko2);
            if (otsikko2.equals("insert")) {
                logger.info("lisäyshaara, seuraavaksi tankin lisäys sivun tiedoilla");
                TankkiDao tankkiDao = new TankkiDaoImpl();
                tankkiDao.lisaaTankki(muodostaTankki(request));
            } else if (otsikko2.equals("update")) {
                logger.info("muokkaushaara, seuraavaksi tankin päivitys sivun tiedoilla");
                TankkiDao tankkiDao = new TankkiDaoImpl();
                tankkiDao.paivitaTankki(muodostaTankki(request));
            }
        }

        int id;
        try {
            id = Integer.parseInt(idParam);
            logger.info("id = " + id);

            TankkiDao tankkiDao = new TankkiDaoImpl();
            Tankki t = tankkiDao.haeTankki(id);

            logger.info("tankki = " + t.getNimi());

            request.setAttribute("tankki", t);
            request.setAttribute("otsikko", "muokkaus");
            request.setAttribute("otsikko2", "update");

            if (muokkaa.equals("true") && kirjautunut != null) {
                dispatcher = request.getRequestDispatcher("WEB-INF/jsp/muokkaatankki.jsp");
            } else {

                dispatcher = request.getRequestDispatcher("WEB-INF/jsp/tankki.jsp");
            }
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

        dispatcher = request.getRequestDispatcher("WEB-INF/jsp/tankkilista.jsp");
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

    private Tankki muodostaTankki(HttpServletRequest request) {

        logger.logp(Level.INFO, TankkiServlet.class.getName(), "muodostaTankki", "alussa");

        Tankki t = new Tankki();

        try {
            t.setUid(Integer.parseInt(request.getParameter("uid")));
        } catch (NumberFormatException e) {
            logger.info("uid:tä ei tullut sivulta, jatketaan muilla parametreillä");
        }
        t.setNimi(request.getParameter("nimi"));
        t.setTyyppi(request.getParameter("tyyppi"));
        t.setTykki(request.getParameter("tykki"));
        t.setPituus(Integer.parseInt(request.getParameter("pituus")));
        t.setLeveys(Integer.parseInt(request.getParameter("leveys")));
        t.setKorkeus(Integer.parseInt(request.getParameter("korkeus")));
        t.setRunkoEtu(Integer.parseInt(request.getParameter("runkoetu")));
        t.setRunkoSivu(Integer.parseInt(request.getParameter("runkosivu")));
        t.setRunkoTaka(Integer.parseInt(request.getParameter("runkotaka")));
        t.setTorniEtu(Integer.parseInt(request.getParameter("tornietu")));
        t.setTorniSivu(Integer.parseInt(request.getParameter("tornisivu")));
        t.setTorniTaka(Integer.parseInt(request.getParameter("tornitaka")));
        t.setPaino(Integer.parseInt(request.getParameter("paino")));
        t.setMoottori(request.getParameter("moottori"));
        t.setTeho(Integer.parseInt(request.getParameter("teho")));
        t.setLisatietoja(request.getParameter("lisatietoja"));

        return t;
    }

}
