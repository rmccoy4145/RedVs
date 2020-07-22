/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mccoy.redvs.main;

import java.io.File;
import java.io.InputStream;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 *
 * @author rmccoy
 */
public class SoundHandler {
    private static String DMG_FILENAME = "dmgSound.wav";
    private static InputStream dmgSound = SoundHandler.class.getResourceAsStream(DMG_FILENAME);
    
    public static void dmgSound() {
        playSound(dmgSound);
    }
    
    public static void playSound(InputStream is) {
    try {
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(is);
        Clip clip = AudioSystem.getClip();
        clip.open(audioInputStream);
        clip.start();
    } catch(Exception ex) {
        System.out.println("Error with playing sound.");
        ex.printStackTrace();
    }
}
}
