/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mccoy.redvs.controllers;

import com.mccoy.redvs.controllers.StartMenuController;
import com.mccoy.redvs.controllers.PlayerController;
import com.mccoy.redvs.assets.GameObject;
import com.mccoy.redvs.main.Handler;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Iterator;

/**
 *
 * @author rmccoy
 */
public class KeyInput extends KeyAdapter{

    private Handler handler;
    private PlayerController playerController = new PlayerController();
    private StartMenuController startMenuController = new StartMenuController();
    public KeyInput(Handler handler) {
        this.handler = handler;
    }
    
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (handler.playing) {
            for (Iterator<GameObject> iterator = handler.objects.iterator(); iterator.hasNext();) {
                GameObject next = iterator.next();
                playerController.movePlayer(key, next);
                playerController.playerActions(key, next);

            }

        }
        if (handler.startMenu) {
            for (Iterator<GameObject> iterator = handler.objects.iterator(); iterator.hasNext();) {
                GameObject next = iterator.next();
                startMenuController.navigation(key, next);
                startMenuController.menuActions(key, next);
            }

        }
    }
       
    

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (handler.playing) {
            for (Iterator<GameObject> iterator = handler.objects.iterator(); iterator.hasNext();) {
                GameObject next = iterator.next();
                playerController.stopPlayer(key, next);

            }
        }

    }
    
    
}
