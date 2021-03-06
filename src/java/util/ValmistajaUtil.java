/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import com.antero.tankkitietokanta.model.Valmistaja;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Antero Oikkonen
 */
public class ValmistajaUtil {

    public static Valmistaja muodostaValmistaja(HttpServletRequest request) {
        Valmistaja v = new Valmistaja();
        String virheet = "";
        String uid = request.getParameter("uid");

        if (uid != null && !uid.equals("")) {
            v.setUid(Integer.parseInt(uid));
        }

        String nimi = request.getParameter("nimi");
        if (nimi != null && !nimi.equals("")) {
            v.setNimi(nimi);

        } else {
            virheet += "nimi ei saa olla tyhjä";
        }
        String paikkakunta = request.getParameter("paikkakunta");
        if (paikkakunta != null && !paikkakunta.equals("")) {
            v.setPaikkakunta(paikkakunta);

        } else {
            virheet += " paikkakunta ei saa olla tyhjä";
        }
        if (virheet.equals("")) {
            return v;
        } else {
            JSPUtil.asetaVirhe(request, virheet);
            return null;
        }

    }
}
