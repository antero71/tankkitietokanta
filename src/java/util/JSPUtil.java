/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.HttpRequest;

/**
 *
 * @author Antero Oikkonen
 */
public class JSPUtil {

    public static void naytaJSP(HttpServletRequest request, HttpServletResponse response, String jspsivu) {
        RequestDispatcher dispatcher = null;
        //dispatcher = request.getRequestDispatcher("WEB-INF/jsp/muokkaatankki.jsp");
        dispatcher = request.getRequestDispatcher(jspsivu);
        try {
            dispatcher.forward(request, response);
        } catch (ServletException ex) {
            Logger.getLogger(JSPUtil.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(JSPUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void asetaVirhe(HttpServletRequest request,String virheIlmoitus){
        request.setAttribute("pageError",virheIlmoitus);
    }
    
    public static void asetaIlmoitus(HttpServletRequest request,String ilmoitus){
        request.setAttribute("ilmoitus",ilmoitus);
    }

}
