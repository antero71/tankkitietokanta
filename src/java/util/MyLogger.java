/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import com.antero.tankkitietokanta.db.TietokantaYhteys;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Antero Oikkonen
 */
public class MyLogger {

    public static String fileName="mylog.txt";
    private static Logger logger;

    public static String getFileName() {
        return fileName;
    }

    public static void setFileName(String fileName) {
        MyLogger.fileName = fileName;
    }

    
    
    public static Logger getLogger(String className) {
        if (logger == null) {
            logger = Logger.getLogger(className);
            FileHandler fh = null;
            try {
                fh = new FileHandler(fileName);
            } catch (IOException ex) {
                Logger.getLogger(TietokantaYhteys.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SecurityException ex) {
                Logger.getLogger(TietokantaYhteys.class.getName()).log(Level.SEVERE, null, ex);
            }
            logger.addHandler(fh);
            logger.setLevel(Level.ALL);
            
        }
        return logger;
    }
}
