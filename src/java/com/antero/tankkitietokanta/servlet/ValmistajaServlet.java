/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.antero.tankkitietokanta.servlet;

import com.antero.tankkitietokanta.db.ValmistajaDao;
import com.antero.tankkitietokanta.db.ValmistajaDaoImpl;
import com.antero.tankkitietokanta.model.Kayttaja;
import com.antero.tankkitietokanta.model.Valmistaja;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import util.JSPUtil;

/**
 *
 * @author Antero Oikkonen
 */
public class ValmistajaServlet extends HttpServlet {

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
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession();
        Kayttaja kirjautunut = (Kayttaja) session.getAttribute("kirjautunut");
        ValmistajaDao dao = new ValmistajaDaoImpl();
        if (kirjautunut != null) {
            //Koodia, jonka vain kirjautunut käyttäjä saa suorittaa

            String lisaa = request.getParameter("lisaa");
            String uid = request.getParameter("uid");
            
            if(uid!=null){
                Valmistaja v = dao.haeValmistaja(Integer.parseInt(uid));
                request.setAttribute("valmistaja", v);
                 JSPUtil.naytaJSP(request, response, "WEB-INF/jsp/valmistaja.jsp");
                return;         
            }

            if (lisaa != null && lisaa.equals("true")) {
                JSPUtil.naytaJSP(request, response, "WEB-INF/jsp/valmistaja.jsp");
                return;
            }

            Valmistaja v = muodostaValmistaja(request);

            dao.lisaaValmistaja(v);
        }
        Collection<Valmistaja> valmistajat = dao.haeValmistajat();
        request.setAttribute("valmistajat", valmistajat);

        JSPUtil.naytaJSP(request, response, "WEB-INF/jsp/valmistajat.jsp");

        //request.gets
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

    private Valmistaja muodostaValmistaja(HttpServletRequest request) {
        Valmistaja v = new Valmistaja();
        v.setNimi(request.getParameter("nimi"));
        v.setPaikkakunta(request.getParameter("paikkakunta"));
        return v;
    }

}
