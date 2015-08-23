/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.antero.tankkitietokanta.servlet;

import com.antero.tankkitietokanta.db.TankkiDao;
import com.antero.tankkitietokanta.db.TankkiDaoImpl;
import com.antero.tankkitietokanta.db.ValmistajaDao;
import com.antero.tankkitietokanta.db.ValmistajaDaoImpl;
import com.antero.tankkitietokanta.model.Kayttaja;
import com.antero.tankkitietokanta.model.Tankki;
import com.antero.tankkitietokanta.model.Valmistaja;
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
import util.JSPUtil;
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
     * Ilman kirjautumista näytetään staattinen tankki sivu. Kirjautunut käyttäjä pääsee
     * muokkaukseen. Kirjautunut käyttäjä voi myös lisätä tankin.
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

        String newParam = request.getParameter("new");

        logger.info("new " + newParam);

        String nayta = request.getParameter("nayta");

        if (nayta != null && nayta.equals("true")) {

            Tankki t = haeTankki(idParam);
            request.setAttribute("tankki", t);
            JSPUtil.naytaJSP(request, response, "WEB-INF/jsp/tankki.jsp");
            return;
        }

        String otsikko = request.getParameter("otsikko");
        String toiminto = request.getParameter("toiminto");

        logger.info("otsikko " + otsikko);

        String poista = request.getParameter("poista");

        if (newParam != null && newParam.equals("true") && kirjautunut != null) {
            request.setAttribute("otsikko", "lisäys");
            request.setAttribute("toiminto", "insert");
            JSPUtil.naytaJSP(request, response, "WEB-INF/jsp/muokkaatankki.jsp");
            return;
        }

        if (toiminto != null) {
            logger.info("otsikko annettu " + otsikko);
            logger.info("toiminto " + toiminto);
            if (toiminto.equals("insert")) {
                logger.info("lisäyshaara, seuraavaksi tankin lisäys sivun tiedoilla");
                TankkiDao tankkiDao = new TankkiDaoImpl();
                Tankki t = muodostaTankki(request);
                if (t.isKelvollinen()) {
                    logger.info("tankki on ok, lisätään");
                    tankkiDao.lisaaTankki(t);
                } else {
                    logger.info("tankin tiedot sivulla eivät ole ok, takaisin muokkaussivulle");
                    request.setAttribute("tankki", t);
                    JSPUtil.naytaJSP(request, response, "WEB-INF/jsp/muokkaatankki.jsp");
                    return;
                }
            } else if (toiminto.equals("update")) {
                logger.info("muokkaushaara, seuraavaksi tankin päivitys sivun tiedoilla");
                TankkiDao tankkiDao = new TankkiDaoImpl();
                tankkiDao.paivitaTankki(muodostaTankki(request));
            }
        }

        int id;
        try {

            Tankki t = haeTankki(idParam);
            request.setAttribute("tankki", t);
            logger.info("tankki = " + t.getNimi());
            request.setAttribute("tankki", t);
            request.setAttribute("otsikko", "muokkaus");
            request.setAttribute("toiminto", "update");

            if (muokkaa.equals("true") && kirjautunut != null) {

                ValmistajaDao dao = new ValmistajaDaoImpl();
                Collection<Valmistaja> valmistajat = dao.haeValmistajat();

                request.setAttribute("valmistajat", valmistajat);

                JSPUtil.naytaJSP(request, response, "WEB-INF/jsp/muokkaatankki.jsp");

            } else {
                Tankki t2 = haeTankki(idParam);
                request.setAttribute("tankki", t2);
                JSPUtil.naytaJSP(request, response, "WEB-INF/jsp/tankki.jsp");
            }
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
        response.sendRedirect("TankkienListaus");
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

        logger.logp(Level.INFO, TankkiServlet.class
                .getName(), "muodostaTankki", "alussa");

        Tankki t = new Tankki();

        try {
            t.setUid(Integer.parseInt(request.getParameter("uid")));
        } catch (NumberFormatException e) {
            logger.info("uid:tä ei tullut sivulta, jatketaan muilla parametreillä");
        }

        t.setNimi(request.getParameter("nimi"));
        t.setTyyppi(request.getParameter("tyyppi"));
        t.setTykki(request.getParameter("tykki"));
        try {
            t.setPituus(Integer.parseInt(request.getParameter("pituus")));
        } catch (NumberFormatException e) {
            t.lisaaVirhe("pituus", "pituuden pitää olla numero");
        }

        try {
            t.setLeveys(Integer.parseInt(request.getParameter("leveys")));
        } catch (NumberFormatException e) {
            t.lisaaVirhe("leveys", "leveyden pitää olla numero");
        }

        try {
            t.setKorkeus(Integer.parseInt(request.getParameter("korkeus")));
        } catch (NumberFormatException e) {
            t.lisaaVirhe("korkeus", "korkeuden pitää olla numero");
        }

        try {
            t.setRunkoEtu(Integer.parseInt(request.getParameter("runkoetu")));
        } catch (NumberFormatException e) {
            t.lisaaVirhe("runkoetu", "rungon etupanssaroinnin paksuus pitää olla numero");
        }

        try {
            t.setRunkoSivu(Integer.parseInt(request.getParameter("runkosivu")));
        } catch (NumberFormatException e) {
            t.lisaaVirhe("runkosivu", "rungon sivupanssaroinnin paksuus pitää olla numero");
        }

        try {
            t.setRunkoTaka(Integer.parseInt(request.getParameter("runkotaka")));
        } catch (NumberFormatException e) {
            t.lisaaVirhe("runkotaka", "rungon takapanssaroinnin paksuus pitää olla numero");
        }

        try {
            t.setTorniEtu(Integer.parseInt(request.getParameter("tornietu")));
        } catch (NumberFormatException e) {
            t.lisaaVirhe("tornietu", "tornin etupanssaroinnin paksuus pitää olla numero");
        }

        try {
            t.setTorniSivu(Integer.parseInt(request.getParameter("tornisivu")));
        } catch (NumberFormatException e) {
            t.lisaaVirhe("tornisivu", "tornin sivupanssaroinnin paksuus pitää olla numero");
        }

        try {
            t.setTorniTaka(Integer.parseInt(request.getParameter("tornitaka")));
        } catch (NumberFormatException e) {
            t.lisaaVirhe("tornitaka", "tornin takapanssaroinnin paksuus pitää olla numero");
        }

        try {
            t.setPaino(Integer.parseInt(request.getParameter("paino")));
        } catch (NumberFormatException e) {
            t.lisaaVirhe("paino", "painon pitää olla numero");
        }

        t.setMoottori(request.getParameter("moottori"));
        try {
            t.setTeho(Integer.parseInt(request.getParameter("teho")));
        } catch (NumberFormatException e) {
            t.lisaaVirhe("teho", "tehon pitää olla numero");
        }

        t.setLisatietoja(request.getParameter("lisatietoja"));

        return t;
    }

    private Tankki haeTankki(String idParam) {
        TankkiDao tankkiDao = new TankkiDaoImpl();
        return tankkiDao.haeTankki(Integer.parseInt(idParam));
    }

}
