/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mccoy.redvs.main;

import java.net.URL;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;

/**
 *
 * @author rmccoy
 */
public class SoundHandler implements LineListener, Runnable{
    private static Resources resources = Resources.getInstance();
    private boolean running = false;
    private Thread thread;

    public SoundHandler() {
        this.start();
    }
    
        public void start()
    {
        if(running)
            return;
        this.thread = new Thread(this);
        this.running = true;
        this.thread.start();
    }
    
    public static void dmgSound() {
        playSound(resources.DMG_SOUND);
    }

    public static void deathSound() {
        playSound(resources.DEATH_SOUND);
    }
    
    public static void playSound(URL url) {
    try {
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(url);
        AudioFormat format = audioInputStream.getFormat();
        DataLine.Info info = new DataLine.Info(Clip.class, format);
        Clip clip = (Clip) AudioSystem.getLine(info);
        clip.open(audioInputStream);

        clip.start();
    } catch(Exception ex) {
        System.out.println("Error with playing sound.");
        ex.printStackTrace();
    }
}

    @Override
    public void update(LineEvent event) {
               LineEvent.Type type = event.getType();
         
        if (type == LineEvent.Type.START) {
            System.out.println("Playback started.");
             
        } else if (type == LineEvent.Type.STOP) {
            System.out.println("Playback completed.");
        }
    }

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
