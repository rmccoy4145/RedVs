/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mccoy.redvs.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 *
 * @author rmccoy
 */
public class KeyInput extends KeyAdapter{

    private Handler handler;
    private PlayerController playerController = new PlayerController();
    public KeyInput(Handler handler) {
        this.handler = handler;
    }
    
    public void keyPressed(KeyEvent e) {
       int key = e.getKeyCode();
        for (GameObject obj : handler.objects) {
            playerController.movePlayer(key, obj);
        }
 
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        for (GameObject obj : handler.objects) {
            playerController.stopPlayer(key, obj);
        }
    }
    
    
}
