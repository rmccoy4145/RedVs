/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mccoy.redvs.main;

import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author rmccoy
 */
public class SoundHandler implements LineListener, Runnable {

    private static Resources resources = Resources.getInstance();
    private boolean running = false;
    private Thread thread;
    private static Clip damage = preLoad(resources.DMG_SOUND);
     private static Clip death = preLoad(resources.DEATH_SOUND);

    public SoundHandler() {
        this.start();

    }

    public void start() {
        if (running) {
            return;
        }
        this.thread = new Thread(this);
        this.running = true;
        this.thread.start();
    }

    public static void dmgSound() {
        playSound(damage);
    }

    public static void deathSound() {
        playSound(death);
    }

    public static void playSound(Clip clip) {
        clip.setMicrosecondPosition(0);
                 clip.start();
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

    private static Clip preLoad(URL url) {
        Clip clip = null;
        try {
            AudioInputStream audioInputStream;
            audioInputStream = AudioSystem.getAudioInputStream(url);
            AudioFormat format = audioInputStream.getFormat();
            DataLine.Info info = new DataLine.Info(Clip.class, format);
            clip = (Clip) AudioSystem.getLine(info);
            clip.open(audioInputStream);
        } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(SoundHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SoundHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (LineUnavailableException ex) {
            Logger.getLogger(SoundHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return clip;

    }

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
