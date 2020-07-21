/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mccoy.redvs.main;

import java.awt.Image;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author rmccoy
 */
public class Resources {
   Image titleImage;
private static Resources instance;

       public static Resources getInstance() {
        if (instance == null) {
            instance = new Resources();
        }
        return instance;
    }
   
    private Resources() {
       try {
           titleImage = ImageIO.read(Resources.class.getClassLoader().getResourceAsStream("REDvs_Title.jpg"));
       } catch (IOException ex) {
           Logger.getLogger(Resources.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
   
   private void resourceCheck() {
               if ( titleImage == null )
               try {
                   throw new Exception("resource not found: ");
               } catch (Exception ex) {
                   Logger.getLogger(Resources.class.getName()).log(Level.SEVERE, null, ex);
               }
   }
    
}
