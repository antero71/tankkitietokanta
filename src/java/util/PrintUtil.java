/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import com.antero.tankkitietokanta.servlet.TankkiServlet;
import java.util.Enumeration;
import java.util.logging.Logger;

/**
 *
 * @author Antero Oikkonen
 */
public class PrintUtil {

    private static Logger logger = MyLogger.getLogger(PrintUtil.class.getName());

    public static void printtaaEnum(String otsikko, Enumeration en) {
        logger.info(otsikko);
        while (en.hasMoreElements()) {
            String nimi = (String) en.nextElement();
            logger.info(otsikko + " " + nimi);
        }
        logger.info(otsikko + " loppu");
    }
}
