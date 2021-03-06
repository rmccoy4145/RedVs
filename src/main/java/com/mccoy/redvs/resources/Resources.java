/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mccoy.redvs.resources;

import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author rmccoy
 */
public class Resources {

   private static String DMG_FILENAME = "dmg.wav";
   private static String DEATH_FILENAME = "death.wav";
   private static String TITLESCREEN_FILENAME = "REDvs_Title.jpg";
   public Image titleImage;
   URL DMG_SOUND;
   URL DEATH_SOUND;
    
private static Resources instance;

       public static Resources getInstance() {
        if (instance == null) {
            instance = new Resources();
        }
        return instance;
    }
   
    private Resources() {
       try {
           DMG_SOUND = Resources.class.getClassLoader().getResource(DMG_FILENAME);
           DEATH_SOUND = Resources.class.getClassLoader().getResource(DEATH_FILENAME);
           titleImage = ImageIO.read(Resources.class.getClassLoader().getResourceAsStream(TITLESCREEN_FILENAME));
       } catch (IOException ex) {
           Logger.getLogger(Resources.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
   
   private void resourceCheck() {
               if ( titleImage == null || DMG_SOUND == null )
               try {
                   throw new Exception("resource not found: ");
               } catch (Exception ex) {
                   Logger.getLogger(Resources.class.getName()).log(Level.SEVERE, null, ex);
               }
   }
    
}
